package com.example.kiranaregister.strategies.currencyconversion;

import com.example.kiranaregister.common.currencyconversion.ConversionRate;
import org.springframework.web.client.RestTemplate;

/**
 * implementation of strategy to convert currencies other than USD being part of from/to.
 */
public class OtherCurrencyConversionStrategy implements CurrencyConversionStrategy{

    @Override
    public Double convert(String from, String to,Double amount) {
        String URI = "https://api.fxratesapi.com/latest";
        RestTemplate restTemplate = new RestTemplate();
        ConversionRate conversionRates = restTemplate.getForObject(URI,ConversionRate.class);
        Double toConversionRate = conversionRates.getRates().get(to);
        Double fromConversionRate = conversionRates.getRates().get(from);
        return (amount*toConversionRate)/fromConversionRate;

    }
}
