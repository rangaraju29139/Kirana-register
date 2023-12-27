package com.example.kiranaregister.dtos.customer;

import com.example.kiranaregister.entities.Customer;

public class CustomerRequestDtoMapper {

    /**
     *
     * mapping of CustomerRequestDto to Customer
     *
     * @param customerRequestDto
     * @return
     */

    public static Customer mapToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder().email(customerRequestDto.getEmail())
                .firstName(customerRequestDto.getFirstName())
                .lastName(customerRequestDto.getLastName())
                .phoneNumber(customerRequestDto.getPhoneNumber())
                .password(customerRequestDto.getPassword())
                .build();
    }
}
