package com.example.kiranaregister.controllers;

import com.example.kiranaregister.dtos.transaction.TransactionRequestDto;
import com.example.kiranaregister.dtos.transaction.TransactionRequestDtoMapper;
import com.example.kiranaregister.dtos.transaction.TransactionResponseDto;
import com.example.kiranaregister.dtos.transaction.TransactionResponseDtoMapper;
import com.example.kiranaregister.entities.Store;
import com.example.kiranaregister.entities.Transaction;
import com.example.kiranaregister.services.CustomerService;
import com.example.kiranaregister.services.StoreService;
import com.example.kiranaregister.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class TransactionController {

    private TransactionService transactionService;
    private StoreService storeService;
    private CustomerService customerService;

    @Autowired
    public TransactionController(@Qualifier("v1") TransactionService transactionService, @Qualifier("v1") StoreService storeService,@Qualifier("v1") CustomerService customerService) {
        this.transactionService = transactionService;
        this.storeService = storeService;
        this.customerService = customerService;
    }


    @RequestMapping(value = "/api/v1/store/{storeId}/transaction",method= RequestMethod.POST)
    public ResponseEntity<TransactionResponseDto> createTransaction(@PathVariable Long storeId, @RequestBody TransactionRequestDto transactionRequestDto){
        Transaction transaction = TransactionRequestDtoMapper.mapToTransaction(transactionRequestDto);
        Optional<Store>  store = storeService.getStore(storeId);
        if(store.isEmpty()) return ResponseEntity.internalServerError().build();
        transaction.setStore(store.get());

        Optional<Transaction> savedTransaction = transactionService.createTransaction(transaction);
        if(savedTransaction.isEmpty()) return ResponseEntity.internalServerError().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transaction.getId()).toUri();
        return ResponseEntity.created(location).body(TransactionResponseDtoMapper.mapToTransactionResponseDto(transaction));
    }

    @RequestMapping(value = "/api/v1/store/{storeId}/transaction/{transactionId}",method = RequestMethod.GET)
    public ResponseEntity<TransactionResponseDto> getTransactionById(@PathVariable Long storeId,@PathVariable Long transactionId){
        Optional<Store> store = storeService.getStore(storeId);
        if(store.isEmpty()) return ResponseEntity.internalServerError().build();
        Optional<Transaction> transaction = transactionService.getTransaction(transactionId).stream().findFirst();
        if(transaction.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(TransactionResponseDtoMapper.mapToTransactionResponseDto(transaction.get()));
    }
}
