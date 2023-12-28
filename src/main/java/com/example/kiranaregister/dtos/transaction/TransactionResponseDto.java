package com.example.kiranaregister.dtos.transaction;


import com.example.kiranaregister.entities.enums.ConsumerType;
import com.example.kiranaregister.entities.enums.CurrencyType;
import com.example.kiranaregister.entities.enums.PaymentType;
import com.example.kiranaregister.entities.enums.TransactionType;
import lombok.*;

import java.time.LocalDateTime;
/**
 * TransactionResponseDto  is a data transfer object to get the info from the transaction object  with out directly mapping to the actual transaction object.
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDto {
    private long id;

    private String description;

    private Long storeId;

    private ConsumerType consumerType;

    private Long consumerId;

    private PaymentType paymentType;

    private String referenceId;

    private double totalAmount;
    private CurrencyType currencyType;
    private LocalDateTime createdTime;
    private TransactionType transactionType;

}
