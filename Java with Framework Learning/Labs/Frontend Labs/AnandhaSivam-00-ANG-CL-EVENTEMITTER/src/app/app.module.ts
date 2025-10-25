import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ButtonMenuComponent } from './components/button-menu/button-menu.component';
import {DisplayComponent} from "./components/display/display.component";

@NgModule({
    declarations: [
        AppComponent,
        ButtonMenuComponent,
        DisplayComponent
    ],
    imports: [
        BrowserModule
    ],
    providers: [],
    exports: [
        DisplayComponent
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
