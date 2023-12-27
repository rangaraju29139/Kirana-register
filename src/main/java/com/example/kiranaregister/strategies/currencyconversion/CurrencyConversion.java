package com.example.kiranaregister.strategies.currencyconversion;

public class CurrencyConversion {

    private CurrencyConversionStrategy currencyConversionStrategy;

    public void setCurrencyConversionStrategy(CurrencyConversionStrategy currencyConversionStrategy){
        this.currencyConversionStrategy = currencyConversionStrategy;
    }
    public Double convertCurrency(String from,String to ,Double amount){
        return currencyConversionStrategy.convert(from,to,amount);

    }
}
