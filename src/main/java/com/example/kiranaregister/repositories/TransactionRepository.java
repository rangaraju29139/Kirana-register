package com.example.kiranaregister.repositories;

import com.example.kiranaregister.entities.Store;
import com.example.kiranaregister.entities.Transaction;
import com.example.kiranaregister.entities.enums.ConsumerType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository helps to get the transaction table data from the repository.
 */
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    /**
     * to get the transactions at store based on the consumer id and the consumer type.
     * @param store
     * @param consumerType
     * @param consumerId
     * @return
     */
    List<Transaction> findTransactionsByStoreAndConsumerTypeAndConsumerId(Store store, ConsumerType consumerType, Long consumerId);

    /**
     * return the transactions happened at the store between the fromDate and toDate
     * @param store
     * @param fromDate
     * @param toDate
     * @return
     */
    List<Transaction> findAllByStoreAndCreatedTimeBetween(Store store, LocalDateTime fromDate, LocalDateTime toDate);

}
