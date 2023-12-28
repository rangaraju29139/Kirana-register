package com.example.kiranaregister.common.currencyconversion;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ConversionRate {
    /**
     * Conversion Rate used to store the data from the api
     */

    private String base;
    private Map<String,Double>  rates;
}
