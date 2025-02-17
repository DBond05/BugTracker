import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuglistComponent } from './components/buglist/buglist.component';
import { BugformComponent } from './components/bugform/bugform.component';
import { BugdetailsComponent } from './components/bugdetails/bugdetails.component';

const routes: Routes = [
  {path:'buglist', component: BuglistComponent},
  {path:'bugform', component: BugformComponent},
  {path:'buglist/:id', component: BugdetailsComponent},
  {path: 'search/:keyword', component: BuglistComponent},
  {path: 'search/', redirectTo: '/buglist', pathMatch:'full'},
  {path: '', redirectTo: '/buglist', pathMatch:'full'},
  {path: '**', redirectTo: '/buglist', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
