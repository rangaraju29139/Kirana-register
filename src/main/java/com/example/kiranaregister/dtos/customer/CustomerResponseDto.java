package com.example.kiranaregister.dtos.customer;

import lombok.*;

/**
 * CustomerResponseDto is a data transfer object to get the info from the endPoint with out directly mapping to the actual customer object to abstract the sensitive info.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
