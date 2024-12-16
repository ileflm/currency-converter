package com.example.currencyConverter.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Currency {

    @Id
    private String currency;
    private double rate;

    // Constructors
    public Currency() {}

    public Currency(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    // Getters and Setters
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
