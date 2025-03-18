import {
    Component,
    computed,
    ElementRef,
    input,
    ViewChild,
} from '@angular/core';
import Paragraph from '../../model/Paragraph';

@Component({
    selector: 'app-editable',
    templateUrl: './editable.component.html',
    styleUrl: './editable.component.scss',
})
export default class EditableComponent {
    paragraphs: Paragraph[] = [
        {
            content: 'test',
            option: 'p',
        },
    ];

    currentParagraph: number = 0;

    @ViewChild('editableContainer')
    editableContainer!: ElementRef<HTMLDivElement>;

    changeHeading(headingLevel: number) {
        this.paragraphs[this.currentParagraph].option = `h${headingLevel}`;
        console.log(this.paragraphs);
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

        getSelection()?.setPosition(paragraph, 1);
    }
}
