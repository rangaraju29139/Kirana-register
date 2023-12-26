package com.example.kiranaregister.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min=2)
    private String firstName;
    @NotNull
    @Size(min=2)
    private String lastName;

    @NotNull
    @Size(min=2)
    @Email
    private String email;

    @NotNull
    @Size(min=2)
    private String password;

    @NotNull
    @Size(min=2)
    @Pattern(regexp = "[0-9]{10}")
    private String phoneNumber;

}
