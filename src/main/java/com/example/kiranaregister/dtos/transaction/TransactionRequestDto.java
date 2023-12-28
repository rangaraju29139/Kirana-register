package com.example.kiranaregister.dtos.transaction;

import com.example.kiranaregister.entities.enums.ConsumerType;
import com.example.kiranaregister.entities.enums.CurrencyType;
import com.example.kiranaregister.entities.enums.PaymentType;
import com.example.kiranaregister.entities.enums.TransactionType;
import lombok.*;

/**
 * TransactionRequestDto is a data transfer object to get the info from the endPoint with out directly mapping to the actual Transaction object.
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDto {
    private String description;

    private ConsumerType consumerType;

    private Long consumerId;

    private PaymentType paymentType;

    private String referenceId;

    private Double totalAmount;
    private CurrencyType currencyType;
    private TransactionType transactionType;

}
