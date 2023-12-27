package com.example.kiranaregister.entities;

import com.example.kiranaregister.entities.enums.ConsumerType;
import com.example.kiranaregister.entities.enums.CurrencyType;
import com.example.kiranaregister.entities.enums.PaymentType;
import com.example.kiranaregister.entities.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3)
    private String description;

    @ManyToOne
    @NotNull
    private Store store;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ConsumerType consumerType;

    @NotNull
    private Long consumerId;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    @NotNull
    private CurrencyType currencyType;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TransactionType transactionType;

    private String referenceId;

    @NotNull
    private double totalAmount;

    @CreationTimestamp
    private LocalDateTime createdTime;
}
