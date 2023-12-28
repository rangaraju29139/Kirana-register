package com.example.kiranaregister.services;

import com.example.kiranaregister.entities.Customer;

import java.util.Optional;

/**
 * Abstraction  for the business login to get the customer related data.
 */
public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Optional<Customer> getCustomer(Long id);
}
