package com.infogalaxy.workshopbookstoreapp.controller;

import com.infogalaxy.workshopbookstoreapp.dto.CustomerRegisterDTO;
import com.infogalaxy.workshopbookstoreapp.entity.CustomerRegisterEntity;
import com.infogalaxy.workshopbookstoreapp.service.BookStoreAppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstoreapp/api")
public class BookStoreAppController {

    @Autowired
    BookStoreAppServiceImpl bookStoreAppService;

    /***
     * Handling REST API call for home
     * @return
     */
    @RequestMapping(value = {"","/","/home"})
    public  String home() {
        return "<h1>Welcome to Book Store App</h1>";
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerRegisterEntity> addCustomer(@Valid @RequestBody CustomerRegisterDTO customerRegisterDTO) {
        return new ResponseEntity<>(bookStoreAppService.addCustomer(customerRegisterDTO), HttpStatus.OK);
    }
}
