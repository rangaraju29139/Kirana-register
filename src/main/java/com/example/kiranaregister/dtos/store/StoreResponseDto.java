package com.example.kiranaregister.dtos.store;

import com.example.kiranaregister.entities.Customer;
import com.example.kiranaregister.entities.enums.CurrencyType;
import lombok.*;



/**
 * StoreResponseDto  is a data transfer object to get the info from the endPoint with out directly mapping to the actual store object.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StoreResponseDto {

    private long id;
    private String name;
    private String description;
    private String address;
    private long storeOwnerId;
    private CurrencyType operationalCurrency;
    private double balance;
}
