import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AllReportsComponent } from './components/all-reports/all-reports.component';
import { AllArticlesComponent } from './components/all-articles/all-articles.component';
import { ReportByIdComponent } from './components/report-by-id/report-by-id.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './components/home/home.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    AllReportsComponent,
    AllArticlesComponent,
    ReportByIdComponent,
    NavbarComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
