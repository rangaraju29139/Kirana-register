package com.example.kiranaregister.entities;

import com.example.kiranaregister.entities.enums.CurrencyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


/**
 * defines a store/kirana store  owned by storeOwner
 */
@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Store {

    /**
     * unique identifier for the store
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * name of the store
     */
    @NotNull
    @Size(min = 2)
    private String name;

    /**
     * description about store
     */
    @NotNull
    @Size(min =2)
    private String description;

    /**
     * address of the store
     */
    @NotNull
    @Size(min =2)
    private String address;

    /**
     * store owner of the store , who is also a customer
     *
     */

    @OneToOne
    private Customer storeOwner;


    /**
     * Operational currency is the type of currency which is accepted at store.
     */
    @Enumerated(EnumType.STRING)
    private CurrencyType operationalCurrency;

    /**
     * total balance at the store.
     * part of future requrirents to get the total balance at any given point in time based on the transactions.
     */
    @NotNull
    private double balance;



}
