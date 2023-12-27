package com.example.kiranaregister.dtos.transaction;

import com.example.kiranaregister.entities.Transaction;

public class TransactionRequestDtoMapper {

    public static Transaction mapToTransaction(TransactionRequestDto transactionRequestDto){
        return Transaction.builder()
                .consumerType(transactionRequestDto.getConsumerType())
                .description(transactionRequestDto.getDescription())
                .referenceId(transactionRequestDto.getReferenceId())
                .totalAmount(transactionRequestDto.getTotalAmount())
                .paymentType(transactionRequestDto.getPaymentType())
                .consumerId(transactionRequestDto.getConsumerId())
                .currencyType(transactionRequestDto.getCurrencyType())
                .transactionType(transactionRequestDto.getTransactionType())
                .referenceId(transactionRequestDto.getReferenceId())
                .build();
    }
}
