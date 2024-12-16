import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CurrencyService {
  private apiUrl = 'http://localhost:8080/api/rates';  // Spring Boot API URL

  constructor(private http: HttpClient) {}

  // Create or Update Currency Rate
  addOrUpdateCurrency(currency: string, rate: number): Observable<any> {
    return this.http.post(this.apiUrl, { currency, rate });
  }

  // Get all Currency Rates
  getAllRates(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  // Get a Specific Currency Rate
  getCurrencyRate(currency: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/${currency}`);
  }

  // Delete Currency Rate
  deleteCurrency(currency: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${currency}`);
  }
}
