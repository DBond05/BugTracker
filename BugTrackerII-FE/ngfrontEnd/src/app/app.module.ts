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
import { FormsModule } from '@angular/forms';
import { YesNoPipe } from './pipes/yes-no.pipe';
import { CapitalizeFirstLetterPipe } from './pipes/capitalize-first-letter.pipe';
import { SearchComponent } from './components/search/search.component';



@NgModule({
  declarations: [
    AppComponent,
    BuglistComponent,
    BugformComponent,
    NavbarComponent,
    BugdetailsComponent,
    YesNoPipe,
    CapitalizeFirstLetterPipe,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BugserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
