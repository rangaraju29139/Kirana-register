package com.example.kiranaregister.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * defines set of users like storeOwners , actual customers etc .
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    /**
     * The unique id of the customer
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The  first name of the customer.
     */
    @NotNull
    @Size(min=2)
    private String firstName;
    /**
     * The last name of the customer.
     */
    @NotNull
    @Size(min=2)
    private String lastName;

    /**
     * The email address of the customer.
     */
    @NotNull
    @Size(min=2)
    @Email
    private String email;

    /**
     * The password of the customer.
     */
    @NotNull
    @Size(min=2)
    private String password;

    /**
     * phone number of the customer.
     */
    @NotNull
    @Size(min=2)
    @Pattern(regexp = "[0-9]{10}")
    private String phoneNumber;

}
