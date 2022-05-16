package com.infogalaxy.workshopbookstoreapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    /***
     * ErrorDetails for Proper Error Details with timestamp, error message and WebRequest details
     */
    private Date timestamp;
    private String message;
    private String details;
}
