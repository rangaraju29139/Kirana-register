package com.example.kiranaregister.entities;

import com.example.kiranaregister.entities.enums.CurrencyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @Size(min =2)
    private String description;

    @NotNull
    @Size(min =2)
    private String address;


    @OneToOne
    private Customer storeOwner;

    @Enumerated(EnumType.STRING)
    private CurrencyType operationalCurrency;

    @NotNull
    private double balance;



}
