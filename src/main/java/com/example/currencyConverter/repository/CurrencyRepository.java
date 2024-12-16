package com.example.currencyConverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.currencyConverter.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
