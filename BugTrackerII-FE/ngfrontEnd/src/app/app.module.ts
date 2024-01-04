import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BugformComponent } from './components/bugform/bugform.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HttpClientModule} from '@angular/common/http';
import { BuglistComponent } from './components/buglist/buglist.component';
import { BugserviceService } from './services/bugservice.service';
import { BugdetailsComponent } from './components/bugdetails/bugdetails.component';



@NgModule({
  declarations: [
    AppComponent,
    BuglistComponent,
    BugformComponent,
    NavbarComponent,
    BugdetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [BugserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
