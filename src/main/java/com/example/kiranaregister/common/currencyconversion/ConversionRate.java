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

    private String base;
    private Map<String,Double>  rates;
}
