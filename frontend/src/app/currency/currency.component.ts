import { Component, OnInit } from '@angular/core';
import { CurrencyService } from '../currency.service';
import { CurrencyRate } from '../currency.model'; // Import the interface

@Component({
  selector: 'app-currency',
  templateUrl: './currency.component.html',
  styleUrls: ['./currency.component.css']
})
export class CurrencyComponent implements OnInit {
  rates: CurrencyRate[] = []; // Specify the type of the array here
  currencyCode: string = '';
  rate: number = 0;

  constructor(private currencyService: CurrencyService) {}

  ngOnInit() {
    this.loadRates();
  }

  // Load all currency rates
  loadRates() {
    this.currencyService.getAllRates().subscribe((data) => {
      this.rates = Object.entries(data).map(([currency, rate]) => ({
        currency,
        rate: Number(rate), // Explicitly cast rate to number
      }));
    });
  }

  // Add or Update currency
  addOrUpdateCurrency() {
    this.currencyService.addOrUpdateCurrency(this.currencyCode, this.rate).subscribe(() => {
      this.loadRates(); // Refresh the rates after adding/updating
    });
  }

  // Delete a currency rate
  deleteCurrency(currency: string) {
    this.currencyService.deleteCurrency(currency).subscribe(() => {
      this.loadRates(); // Refresh the rates after deletion
    });
  }
}
