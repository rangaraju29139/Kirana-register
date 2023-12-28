package com.example.kiranaregister.controllers;

import com.example.kiranaregister.dtos.customer.CustomerRequestDto;
import com.example.kiranaregister.dtos.customer.CustomerRequestDtoMapper;
import com.example.kiranaregister.dtos.customer.CustomerResponseDto;
import com.example.kiranaregister.dtos.customer.CustomerResponseDtoMapper;
import com.example.kiranaregister.entities.Customer;
import com.example.kiranaregister.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


/**
 * Handles all the api requests related to customer
 */
@RestController
public class CustomerController {

    private CustomerService customerService;

    /**
     *
     * @param customerService
     * service layer to handle the business logic of customer related api's
     */

    /**
     * constructor uses dependency injectsion to get the required version of service implementations
     *
     */
    @Autowired
    public CustomerController(@Qualifier("v1") CustomerService customerService){
        this.customerService = customerService;
    }

    /**
     *
     * @param customerRequestDto
     * @return
     *
     * Handles creation of customer with customerRequestDto Mapping
     */


    @RequestMapping(value = "/api/v1/customer", method = RequestMethod.POST)
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto ){
        Customer customer = CustomerRequestDtoMapper.mapToCustomer(customerRequestDto);
        Optional<Customer> savedCustomer = Optional.of(customerService.createCustomer(customer));
        if(savedCustomer.isEmpty()) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }



    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/customer/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable Long id){
        /**
         * Handles the get customer request using customer id
         */
        Optional<Customer> customer = customerService.getCustomer(id);
        if(customer.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(CustomerResponseDtoMapper.mapToCustomerResponseDto(customer.get()));
    }
}
