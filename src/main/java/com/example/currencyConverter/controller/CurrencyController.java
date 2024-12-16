package com.example.currencyConverter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyConverter.model.Currency;
import com.example.currencyConverter.service.CurrencyService;

@RestController
@RequestMapping("/api/rates")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    // Create or Update Currency
    @PostMapping
    public ResponseEntity<String> createOrUpdateCurrency(@RequestBody Currency currency) {
        currencyService.createOrUpdateCurrency(currency);
        return new ResponseEntity<>("Currency rate added/updated.", HttpStatus.CREATED);
    }

    // Get all currency rates
    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    // Get currency rate by currency code
    @GetMapping("/{currency}")
    public ResponseEntity<Currency> getCurrency(@PathVariable String currency) {
        Optional<Currency> result = currencyService.getCurrencyByCode(currency);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete a currency
    @DeleteMapping("/{currency}")
    public ResponseEntity<String> deleteCurrency(@PathVariable String currency) {
        currencyService.deleteCurrency(currency);
        return new ResponseEntity<>("Currency rate deleted.", HttpStatus.OK);
    }
}
        