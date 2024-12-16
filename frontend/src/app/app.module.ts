import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'; // For two-way binding

import { AppComponent } from './app.component';
import { CurrencyComponent } from './currency/currency.component';
import { CurrencyService } from './currency.service';

@NgModule({
  declarations: [
    AppComponent,
    CurrencyComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule // For two-way binding support
  ],
  providers: [CurrencyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
