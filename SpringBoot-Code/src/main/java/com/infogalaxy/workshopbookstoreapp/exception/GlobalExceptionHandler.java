package com.infogalaxy.workshopbookstoreapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    /***
     * Global Exception Handler for INTERNAL_SERVER_ERROR
     * @param exception
     * @param webRequest
     * @return ErrorDetails with timestamp, error message and API call URL
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /***
     * Custom Exception Handler for User Data Exceptions
     * @param customException
     * @param webRequest
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetails> handleCustomException(CustomException customException,WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),customException.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
}
