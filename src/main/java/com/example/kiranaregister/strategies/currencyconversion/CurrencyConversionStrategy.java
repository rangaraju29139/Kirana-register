package com.example.kiranaregister.strategies.currencyconversion;

/**
 * Abstraction for CurrencyStrategies
 * and implementation of interface segregation principle.
 */
public interface CurrencyConversionStrategy {

    public Double convert(String from,String to,Double amount);
}
