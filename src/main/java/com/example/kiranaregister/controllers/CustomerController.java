package com.example.kiranaregister.controllers;

import com.example.kiranaregister.dtos.customer.CustomerRequestDto;
import com.example.kiranaregister.dtos.customer.CustomerRequestDtoMapper;
import com.example.kiranaregister.dtos.customer.CustomerResponseDto;
import com.example.kiranaregister.entities.Customer;
import com.example.kiranaregister.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(@Qualifier("v1") CustomerService customerService){
        this.customerService = customerService;
    }



    @RequestMapping(value = "/api/v1/customer", method = RequestMethod.POST)
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto ){
        Customer customer = CustomerRequestDtoMapper.mapToCustomer(customerRequestDto);
        Optional<Customer> savedCustomer = Optional.of(customerService.createCustomer(customer));
        if(savedCustomer.isEmpty()) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
