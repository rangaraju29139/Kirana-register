package com.example.kiranaregister.services;

import com.example.kiranaregister.entities.Customer;

import java.util.Optional;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Optional<Customer> getCustomer(Long id);
}
