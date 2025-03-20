import {
    AfterViewChecked,
    Component,
    ElementRef,
    HostListener,
    IterableDiffer,
    IterableDiffers,
    KeyValueDiffers,
    ViewChild,
} from '@angular/core';
import Paragraph from '../../model/Paragraph';

@Component({
    selector: 'app-editable',
    templateUrl: './editable.component.html',
    styleUrl: './editable.component.scss',
})
export default class EditableComponent implements AfterViewChecked {
    paragraphs: Paragraph[] = [
        {
            option: 'p',
        },
    ];

    currentParagraph = 0;
    changedPosition = -1;

    private differ: IterableDiffer<Paragraph>;

    @ViewChild('editableContainer')
    editableContainer!: ElementRef<HTMLDivElement>;

    constructor(
        private iterableDiffers: IterableDiffers,
        private keyValueDiffers: KeyValueDiffers,
    ) {
        this.differ = this.iterableDiffers.find(this.paragraphs).create();
    }

    ngAfterViewChecked(): void {
        const changes = this.differ.diff(this.paragraphs);

        changes?.forEachAddedItem((record) => {
            if (record.currentIndex) {
                const paragraph =
                    this.editableContainer.nativeElement.children.item(
                        record.currentIndex,
                    ) as HTMLElement;

                paragraph?.focus();
            }
        });

        changes?.forEachRemovedItem((record) => {
            if (record.previousIndex) {
                const paragraphElement =
                    this.editableContainer.nativeElement.children.item(
                        record.previousIndex - 1,
                    ) as HTMLElement;

                paragraphElement.focus();
                const selection = window.getSelection();

                if (paragraphElement.textContent && record.item.content) {
                    selection?.setPosition(
                        paragraphElement.firstChild,
                        paragraphElement.textContent?.length -
                            record.item.content?.length,
                    );
                } else {
                    selection?.setPosition(paragraphElement, 1);
                }
            }
        });

        if (this.changedPosition >= 0) {
            const paragraphElement =
                this.editableContainer.nativeElement.children.item(
                    this.currentParagraph,
                ) as HTMLElement;

            paragraphElement.focus();
            window
                .getSelection()
                ?.setPosition(
                    paragraphElement.firstChild,
                    this.changedPosition,
                );
            this.changedPosition = -1;
        }
    }

    changeHeading(headingLevel: number) {
        this.paragraphs[this.currentParagraph].option = `h${headingLevel}`;
        const selection = getSelection();

        if (selection) {
            this.changedPosition = selection.getRangeAt(0).endOffset;
        }
    }

    setParagraph(currentParagraph: number) {
        this.currentParagraph = currentParagraph;
    }

    input(index: number) {
        const paragraph =
            this.editableContainer.nativeElement.children.item(index);

        this.paragraphs[index].content = paragraph?.textContent;
    }

    getTextAfterCaret() {
        const selection = window.getSelection();

        const range = selection?.getRangeAt(0);

        const paragraph = this.paragraphs[this.currentParagraph];

        if (paragraph.content && range) {
            return paragraph.content.substring(range.endOffset);
        }

        return undefined;
    }

    removeTextAfterCaret() {
        const selection = window.getSelection();

        const range = selection?.getRangeAt(0);

        const paragraph = this.paragraphs[this.currentParagraph];

        paragraph.content = paragraph.content?.substring(0, range?.startOffset);
    }

    @HostListener('keydown', ['$event'])
    keydown(e: KeyboardEvent) {
        if (e.key === 'Enter') {
            e.preventDefault();

            this.paragraphs.splice(this.currentParagraph + 1, 0, {
                option: 'p',
                content: this.getTextAfterCaret(),
            });

            this.removeTextAfterCaret();
        }

        if (e.key === 'Backspace') {
            const selection = window.getSelection();

            const range = selection?.getRangeAt(0);

            const paragraph = this.paragraphs[this.currentParagraph];

            if (range?.endOffset === 0 && paragraph.option.startsWith('h')) {
                paragraph.option = 'p';
                this.changedPosition = 0;
            }

            if (range?.endOffset === 0 && this.currentParagraph > 0) {
                const deletedParagraph = this.paragraphs.splice(
                    this.currentParagraph,
                    1,
                )[0];

                const previousParagraph =
                    this.paragraphs[this.currentParagraph - 1];

                if (previousParagraph.content && deletedParagraph.content) {
                    previousParagraph.content += deletedParagraph.content;
                } else if (
                    !previousParagraph.content &&
                    deletedParagraph.content
                ) {
                    previousParagraph.content = deletedParagraph.content;
                }
            }
        }
    }
}
