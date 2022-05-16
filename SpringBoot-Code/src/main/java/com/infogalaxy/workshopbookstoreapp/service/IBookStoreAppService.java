package com.infogalaxy.workshopbookstoreapp.service;

import com.infogalaxy.workshopbookstoreapp.dto.CustomerRegisterDTO;
import com.infogalaxy.workshopbookstoreapp.entity.CustomerRegisterEntity;

public interface IBookStoreAppService {

    /***
     * Service to Add Customer to App
     */
    CustomerRegisterEntity addCustomer(CustomerRegisterDTO customerRegisterDTO);
}
