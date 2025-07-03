import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { ContractDocumentsComponent } from './contract-documents/contract-documents.component';
import { GlobalErrorComponent } from './global-error/global-error.component';

const routes: Routes = [
  { path: 'welcome-page', component: WelcomePageComponent },
  { path: 'contract-documents', component: ContractDocumentsComponent },
  // { path: 'angular-tutorial', component: AngularDefaultComponent },
  // { path: 'dashboard', component: DashboardComponent },
  { path: '',   redirectTo: '/welcome-page', pathMatch: 'full' }, // redirect to `first-component`
  { path: '**', redirectTo: '' },  // Wildcard route for a 404 page
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
