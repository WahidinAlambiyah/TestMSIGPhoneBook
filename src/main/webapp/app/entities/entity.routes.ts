import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'authority',
    data: { pageTitle: 'testMsigPhoneBookApp.adminAuthority.home.title' },
    loadChildren: () => import('./admin/authority/authority.routes'),
  },
  {
    path: 'person',
    data: { pageTitle: 'testMsigPhoneBookApp.person.home.title' },
    loadChildren: () => import('./person/person.routes'),
  },
  {
    path: 'contact',
    data: { pageTitle: 'testMsigPhoneBookApp.contact.home.title' },
    loadChildren: () => import('./contact/contact.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
