package com.example.currencyConverter.service;

import com.example.currencyConverter.model.Currency;
import com.example.currencyConverter.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    // Create or Update Currency
    public Currency createOrUpdateCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    // Get all currencies
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    // Get a specific currency rate
    public Optional<Currency> getCurrencyByCode(String currencyCode) {
        return currencyRepository.findById(currencyCode);
    }

    // Delete a currency
    public void deleteCurrency(String currencyCode) {
        currencyRepository.deleteById(currencyCode);
    }
}
