package com.example.kiranaregister.dtos.customer;

import com.example.kiranaregister.entities.Customer;

public class CustomerResponseDtoMapper {


    public static CustomerResponseDto mapToCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }
}
