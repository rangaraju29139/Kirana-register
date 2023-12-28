package com.example.kiranaregister.dtos.customer;

import com.example.kiranaregister.entities.Customer;

public class CustomerResponseDtoMapper {

    /**
     * Mapping the Customer to CustomerResponseDto to achieve the abstraction for the customer and to hide the sensitive data.
     * @param customer
     * @return
     */
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
