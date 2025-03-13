import { Component, OnInit } from '@angular/core';
import Documentation, { DocumentationState } from '../../model/Documentation';
import { DatePipe, LowerCasePipe } from '@angular/common';
import DocumentationService from '../../service/DocumentationService';

@Component({
    templateUrl: './home.component.html',
    styleUrl: './home.component.scss',
    imports: [LowerCasePipe, DatePipe],
    providers: [DocumentationService],
})
export default class HomeComponent implements OnInit {
    documentations: Documentation[] = [];
    DocumentationState = DocumentationState;

    constructor(private docService: DocumentationService) {}

    ngOnInit() {
        this.fetchDocumentations();
    }

    fetchDocumentations() {
        this.docService.getDocumentations(null, null).subscribe((data) => {
            this.documentations = data;
        });
    }
}
