package com.example.kiranaregister.dtos.store;

import com.example.kiranaregister.entities.Customer;
import com.example.kiranaregister.entities.enums.CurrencyType;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StoreRequestDto {
    private String name;
    private String description;
    private String address;
    private long storeOwnerId;
    private CurrencyType operationalCurrency;
    private double balance;
}