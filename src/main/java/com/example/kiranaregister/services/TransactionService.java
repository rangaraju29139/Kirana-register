package com.example.kiranaregister.services;

import com.example.kiranaregister.dtos.transaction.TransactionResponseDto;
import com.example.kiranaregister.entities.Store;
import com.example.kiranaregister.entities.Transaction;
import com.example.kiranaregister.entities.enums.ConsumerType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Abstraction for the business login of trasaction related queries.
 */
public interface TransactionService {
    public Optional<Transaction> createTransaction(Transaction transaction);
    public Optional<Transaction> getTransaction(Long id);
    public Optional<List<Transaction>> getAllTransactionsAtStoreByConsumer(Store store, ConsumerType consumerType, Long consumerId);

   public  Optional<List<Transaction>> getStoreStatement(Store store, LocalDateTime fromDate, LocalDateTime toDate);
}
