package com.example.kiranaregister.dtos.customer;


import lombok.*;

/**
 * CustomerRequestDto is a data transfer object to get the info from the endPoint with out directly mapping to the actual customer object.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
}
