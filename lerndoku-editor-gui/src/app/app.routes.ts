import { Routes } from '@angular/router';
import HomeComponent from './page/home/home.component';
import EditorComponent from './page/editor/editor.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent,
    },
    {
        path: 'create',
        component: EditorComponent,
    },
];
