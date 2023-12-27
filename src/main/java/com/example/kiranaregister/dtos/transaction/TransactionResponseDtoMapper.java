package com.example.kiranaregister.dtos.transaction;

import com.example.kiranaregister.entities.Transaction;

public class TransactionResponseDtoMapper {

    public static TransactionResponseDto mapToTransactionResponseDto(Transaction transaction){
        return TransactionResponseDto.builder()
                .id(transaction.getId())
                .consumerType(transaction.getConsumerType())
                .description(transaction.getDescription())
                .paymentType(transaction.getPaymentType())
                .referenceId(transaction.getReferenceId())
                .consumerId(transaction.getConsumerId())
                .storeId(transaction.getStore().getId())
                .totalAmount(transaction.getTotalAmount())
                .build();

    }
}
