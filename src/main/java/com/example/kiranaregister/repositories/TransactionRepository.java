package com.example.kiranaregister.repositories;

import com.example.kiranaregister.entities.Transaction;
import com.example.kiranaregister.entities.enums.ConsumerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findTransactionsByConsumerTypeAndConsumerId(ConsumerType consumerType, Long consumerId);
}