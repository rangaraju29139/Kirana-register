package com.example.kiranaregister.services;

import com.example.kiranaregister.dtos.transaction.TransactionResponseDto;
import com.example.kiranaregister.entities.Transaction;
import com.example.kiranaregister.entities.enums.ConsumerType;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    public Optional<Transaction> createTransaction(Transaction transaction);
    public Optional<Transaction> getTransaction(Long id);
    public Optional<List<Transaction>> getAllTransactionsByConsumer(ConsumerType consumerType, Long consumerId);

}
