package com.example.kiranaregister.strategies.currencyconversion;

import com.example.kiranaregister.common.currencyconversion.ConversionRate;
import org.springframework.web.client.RestTemplate;

/**
 * strategy implementaion for currency conversion with USD being part of from/to currency.
 */
public class UsdCurrencyConversionStrategy implements CurrencyConversionStrategy{

    @Override
    public Double convert(String from, String to,Double amount) {
        String URI = "https://api.fxratesapi.com/latest";
        RestTemplate restTemplate = new RestTemplate();
        ConversionRate conversionRates = restTemplate.getForObject(URI,ConversionRate.class);


        if(from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("INR")){
           return conversionRates.getRates().get(to)*amount;

        }else{
            return amount/(conversionRates.getRates().get(from));
        }
    }
}
