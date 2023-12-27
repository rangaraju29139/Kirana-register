package com.example.kiranaregister.strategies.currencyconversion;

import com.example.kiranaregister.common.currencyconversion.ConversionRate;
import org.springframework.web.client.RestTemplate;

public class UsdCurrencyConversionStrategy implements CurrencyConversionStrategy{

    @Override
    public Double convert(String from, String to,Double amount) {
        String URI = "https://api.fxratesapi.com/latest";
        RestTemplate restTemplate = new RestTemplate();
        ConversionRate conversionRates = restTemplate.getForObject(URI,ConversionRate.class);


        if(from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("INR")){
           return conversionRates.getRates().get(to)*amount;

        }else
//        if(from.equalsIgnoreCase("INR") && to.equalsIgnoreCase("USD"))
        {
            return amount/(conversionRates.getRates().get(from));
        }
    }
}
