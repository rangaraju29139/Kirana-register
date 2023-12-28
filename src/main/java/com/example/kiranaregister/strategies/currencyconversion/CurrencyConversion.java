package com.example.kiranaregister.strategies.currencyconversion;

/**
 * Strategy Design pattern implementaion for currency conversion
 */
public class CurrencyConversion {

    private CurrencyConversionStrategy currencyConversionStrategy;

    /**
     * Helps to update the different strategy implementations at run time.
     * @param currencyConversionStrategy
     */
    public void setCurrencyConversionStrategy(CurrencyConversionStrategy currencyConversionStrategy){
        this.currencyConversionStrategy = currencyConversionStrategy;
    }

    /**
     * defines to run the convert method from the current strategy implementation.
     * @param from
     * @param to
     * @param amount
     * @return
     */
    public Double convertCurrency(String from,String to ,Double amount){
        return currencyConversionStrategy.convert(from,to,amount);

    }
}
