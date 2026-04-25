import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('../create-note/create-note').then((m) => m.CreateNote),
  },
];
