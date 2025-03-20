import {
    AfterViewChecked,
    Component,
    ElementRef,
    HostListener,
    IterableDiffer,
    IterableDiffers,
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

    private differ: IterableDiffer<Paragraph>;

    @ViewChild('editableContainer')
    editableContainer!: ElementRef<HTMLDivElement>;

    constructor(private iterableDiffers: IterableDiffers) {
        this.differ = this.iterableDiffers.find(this.paragraphs).create();
    }

    ngAfterViewChecked(): void {
        const changes = this.differ.diff(this.paragraphs);

        if (changes) {
            changes.forEachAddedItem((record) => {
                if (record.currentIndex) {
                    const paragraph =
                        this.editableContainer.nativeElement.children.item(
                            record.currentIndex,
                        ) as HTMLElement;

                    paragraph?.focus();
                }
            });
        }
    }

    changeHeading(headingLevel: number) {
        this.paragraphs[this.currentParagraph].option = `h${headingLevel}`;
    }

    setParagraph(currentParagraph: number) {
        this.currentParagraph = currentParagraph;
    }

    input(index: number) {
        const paragraph =
            this.editableContainer.nativeElement.children.item(index);

        if (paragraph?.textContent) {
            this.paragraphs[index].content = paragraph.textContent;
        }
    }

    getTextAfterCaret() {
        const selection = window.getSelection();

        const range = selection?.getRangeAt(0);

        const paragraph = this.paragraphs[this.currentParagraph];

        if (paragraph.content && range) {
            return paragraph.content.substring(range.startOffset);
        }

        return undefined;
    }

    getRange() {
        const selection = window.getSelection();

        return selection?.getRangeAt(0);
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

            const range = this.getRange();

            this.paragraphs.splice(this.currentParagraph + 1, 0, {
                option: 'p',
                content:
                    range?.startOffset === range?.endOffset
                        ? this.getTextAfterCaret()
                        : undefined,
            });

            this.removeTextAfterCaret();
        }
    }
}
