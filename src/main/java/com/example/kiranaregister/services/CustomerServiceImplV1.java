package com.example.kiranaregister.services;

import com.example.kiranaregister.entities.Customer;
import com.example.kiranaregister.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("v1")
public class CustomerServiceImplV1 implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
