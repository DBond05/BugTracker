import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuglistComponent } from './components/buglist/buglist.component';
import { BugformComponent } from './components/bugform/bugform.component';

const routes: Routes = [
  {path:'buglist', component: BuglistComponent},
  {path:'bugform', component: BugformComponent},
  {path: '', redirectTo: '/buglist', pathMatch:'full'},
  {path: '**', redirectTo: '/buglist', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
