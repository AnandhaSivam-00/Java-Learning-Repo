import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgIfComponent } from './components/ng-if/ng-if.component';
import { NgForComponent } from './components/ng-for/ng-for.component';
import { NgStyleComponent } from './components/ng-style/ng-style.component';
import {PipesComponent} from "./components/pipes/pipes.component";
import {NgClassComponent} from "./components/ng-class/ng-class.component";
import {FormsModule} from "@angular/forms";
import {NgSwitchComponent} from "./components/ng-switch/ng-switch.component";

@NgModule({
  declarations: [
    AppComponent,
    NgIfComponent,
    NgForComponent,
    NgStyleComponent,
    NgSwitchComponent,
    PipesComponent,
    NgClassComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
