import { Component, OnInit } from '@angular/core';
import Documentation, { DocumentationState } from '../../model/Documentation';
import { DatePipe, LowerCasePipe } from '@angular/common';
import DocumentationService from '../../service/DocumentationService';
import { FormsModule } from '@angular/forms';

@Component({
    templateUrl: './home.component.html',
    styleUrl: './home.component.scss',
    imports: [LowerCasePipe, DatePipe, FormsModule],
    providers: [DocumentationService],
})
export default class HomeComponent implements OnInit {
    documentations: Documentation[] = [];
    DocumentationState = DocumentationState;

    semester: string | null = null;

    constructor(private docService: DocumentationService) {}

    ngOnInit() {
        this.fetchDocumentations();
    }

    changeSemester() {
        if (this.semester === 'null' || this.semester === null) {
            this.semester = null;
        }
        this.fetchDocumentations();
    }

    fetchDocumentations() {
        let semester = null;
        if (this.semester !== null) {
            semester = +this.semester;
        }
        this.docService.getDocumentations(semester, null).subscribe((data) => {
            this.documentations = data;
        });
    }
}
