package com.example.kiranaregister.controllers;

import com.example.kiranaregister.dtos.transaction.TransactionRequestDto;
import com.example.kiranaregister.dtos.transaction.TransactionRequestDtoMapper;
import com.example.kiranaregister.dtos.transaction.TransactionResponseDto;
import com.example.kiranaregister.dtos.transaction.TransactionResponseDtoMapper;
import com.example.kiranaregister.entities.Store;
import com.example.kiranaregister.entities.Transaction;
import com.example.kiranaregister.entities.enums.ConsumerType;
import com.example.kiranaregister.services.CustomerService;
import com.example.kiranaregister.services.StoreService;
import com.example.kiranaregister.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Handles the all Requests related to transactions
 */
@RestController
public class TransactionController {

    private TransactionService transactionService;
    private StoreService storeService;
    private CustomerService customerService;

    /**
     *
     * @param transactionService
     * @param storeService
     * @param customerService
     * construction to initialize through dependency injection of the respective versions of service implementations
     */
    @Autowired
    public TransactionController(@Qualifier("v1") TransactionService transactionService, @Qualifier("v1") StoreService storeService,@Qualifier("v1") CustomerService customerService) {
        this.transactionService = transactionService;
        this.storeService = storeService;
        this.customerService = customerService;
    }


    /**
     * Handle the creation of transaction at particular store id
     * @param storeId
     * @param transactionRequestDto
     * @return
     */
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

    /**
     * Handles to get the particular transactions at particular store
     * @param storeId
     * @param transactionId
     * @return
     */
    @RequestMapping(value = "/api/v1/store/{storeId}/transaction/{transactionId}",method = RequestMethod.GET)
    public ResponseEntity<TransactionResponseDto> getTransactionById(@PathVariable Long storeId,@PathVariable Long transactionId){
        Optional<Store> store = storeService.getStore(storeId);
        if(store.isEmpty()) return ResponseEntity.internalServerError().build();
        Optional<Transaction> transaction = transactionService.getTransaction(transactionId).stream().findFirst();
        if(transaction.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(TransactionResponseDtoMapper.mapToTransactionResponseDto(transaction.get()));
    }

    /**
     * handle to retrieve all the transactions at particular store id.
     * @param storeId
     * @return
     */
    @RequestMapping(value = "/api/v1/store/{storeId}/transactions", method=RequestMethod.GET)
    public ResponseEntity<List<TransactionResponseDto>> getTransactionAtByStoreId(@PathVariable Long storeId){
        Optional<Store> store = storeService.getStore(storeId);
        if(store.isEmpty()) return ResponseEntity.internalServerError().build();
        Optional<List<Transaction>> transactions = transactionService.getAllTransactionsAtStoreByConsumer(store.get(), ConsumerType.STORE,storeId);
        if(transactions.isEmpty()) return ResponseEntity.notFound().build();
        List<TransactionResponseDto> resultTransactions = transactions.get().stream().map(TransactionResponseDtoMapper::mapToTransactionResponseDto).collect(Collectors.toList());
        return ResponseEntity.ok(resultTransactions);
    }

    /**
     * handles to get the transactions to get the transactinos based on the customer id
     * @param storeId
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/api/v1/store/{storeId}/customer/{customerId}/transactions", method=RequestMethod.GET)
    public ResponseEntity<List<TransactionResponseDto>> getTransactionByStoreIdAndCustomerId(@PathVariable Long storeId,@PathVariable Long customerId){
        Optional<Store> store = storeService.getStore(storeId);
        if(store.isEmpty()) return ResponseEntity.internalServerError().build();
        Optional<List<Transaction>> transactions = transactionService.getAllTransactionsAtStoreByConsumer(store.get(), ConsumerType.CUSTOMER,customerId);
        if(transactions.isEmpty()) return ResponseEntity.notFound().build();
        List<TransactionResponseDto> resultTransactions = transactions.get().stream().map(TransactionResponseDtoMapper::mapToTransactionResponseDto).collect(Collectors.toList());
        return ResponseEntity.ok(resultTransactions);
    }
}
