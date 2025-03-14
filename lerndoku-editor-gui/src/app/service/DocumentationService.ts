import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import Documentation, { DocumentationState } from '../model/Documentation';

@Injectable({ providedIn: 'root' })
export default class DocumentationService {
    private apiUrl = 'http://localhost:8080/documentations';

    constructor(private http: HttpClient) {}

    getDocumentations(
        semester: number | null,
        state: DocumentationState | null,
    ): Observable<Documentation[]> {
        let params = new HttpParams();
        if (semester != null) {
            params = params.append('semester', semester);
        }

        if (state != null) {
            params = params.append('state', state);
        }
        return this.http.get<Documentation[]>(this.apiUrl, { params }).pipe(
            map<Documentation[], Documentation[]>((docs: Documentation[]) => {
                return docs.map((doc) => ({
                    ...doc,
                    state: DocumentationState[doc.state],
                }));
            }),
        );
    }
}
