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

/**
 * Transaction defines the buying and purchasing at the store
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "transaction")
public class Transaction {

    /**
     * unique identifier for the transaction
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * transaction description  which can include the items purchased and the quantity etc.
     */
    @NotNull
    @Size(min = 3)
    private String description;

    /**
     * defines the store at which the transaction is being made
     */
    @ManyToOne
    @NotNull
    private Store store;

    /**
     * defines the type of consumer whether it is other store or customer.
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    private ConsumerType consumerType;

    /**
     * defines the consumer id based on the type of consumer, it can be customerId or stoerId.
     */
    @NotNull
    private Long consumerId;


    /**
     * defines the type of payment used for the transaction.
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    private PaymentType paymentType;

    /**
     * defines the currency type used for the transaction.
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    private CurrencyType currencyType;

    /**
     * defines whether it is a CREDIT transaction or DEBIT.
     */

    @Enumerated(EnumType.STRING)
    @NotNull
    private TransactionType transactionType;

    /**
     * defines the optional reference id of the payment for book keeping.
     */
    private String referenceId;

    /**
     * defines the total amount of the transaction.
     */
    @NotNull
    private double totalAmount;

    /**
     * defines the time at the trasaction occured.
     */
    @CreationTimestamp
    private LocalDateTime createdTime;
}
