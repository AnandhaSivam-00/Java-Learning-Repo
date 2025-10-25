import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MenuComponent } from './components/menu/menu.component';
import { IncrementorComponent } from './components/incrementor/incrementor.component';
import { DecrementorComponent } from './components/decrementor/decrementor.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    IncrementorComponent,
    DecrementorComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
