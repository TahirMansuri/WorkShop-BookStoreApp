package com.infogalaxy.workshopbookstoreapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterDTO {
    private String firstName;
    private String lastName;
    private String kyc;
    //LocalDate format must be YYYY-MM-DD
    private LocalDate dob;
    private LocalDate registerDate;
    private LocalDate updateDate;
    private String password;
    private String emailId;
    private Boolean verify;
    private LocalDate purchaseDate;
    private LocalDate expiryDate;
}
