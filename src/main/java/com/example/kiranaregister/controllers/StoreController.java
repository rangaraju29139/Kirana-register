package com.example.kiranaregister.controllers;

import com.example.kiranaregister.dtos.store.StoreRequestDto;
import com.example.kiranaregister.dtos.store.StoreRequestDtoMapper;
import com.example.kiranaregister.dtos.store.StoreResponseDto;
import com.example.kiranaregister.dtos.store.StoreResponseDtoMapper;
import com.example.kiranaregister.entities.Customer;
import com.example.kiranaregister.entities.Store;
import com.example.kiranaregister.services.CustomerService;
import com.example.kiranaregister.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class StoreController {

    private StoreService storeService;

    private CustomerService customerService;

    @Autowired
    public StoreController(@Qualifier("v1") StoreService storeService, @Qualifier("v1") CustomerService customerService){
        this.storeService=storeService;
        this.customerService = customerService;
    }


    @RequestMapping(value = "/api/v1/store",method = RequestMethod.POST)
    public ResponseEntity<StoreResponseDto> createStore(@RequestBody StoreRequestDto storeRequestDto){
        Store store = StoreRequestDtoMapper.mapToStore(storeRequestDto);
        Optional<Customer> storeOwner = customerService.getCustomer(storeRequestDto.getStoreOwnerId());
        if(storeOwner.isEmpty()) return ResponseEntity.internalServerError().build();
        store.setStoreOwner(storeOwner.get());

        Optional<Store> savedStore = Optional.of(storeService.createStore(store));
        if(savedStore.isEmpty()) return ResponseEntity.internalServerError().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(store.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/api/v1/store/{storeId}", method = RequestMethod.GET)
    public ResponseEntity<StoreResponseDto> getStore(@PathVariable long storeId){
        Optional<Store> savedStore = storeService.getStore(storeId);
        if(savedStore.isEmpty()) return ResponseEntity.internalServerError().build();
        return ResponseEntity.ok(StoreResponseDtoMapper.mapToStoreResponseDto(savedStore.get()));
    }

}
