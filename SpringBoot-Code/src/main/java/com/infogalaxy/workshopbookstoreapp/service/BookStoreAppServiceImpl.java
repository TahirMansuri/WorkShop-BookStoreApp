package com.infogalaxy.workshopbookstoreapp.service;

import com.infogalaxy.workshopbookstoreapp.dto.CustomerRegisterDTO;
import com.infogalaxy.workshopbookstoreapp.entity.CustomerRegisterEntity;
import com.infogalaxy.workshopbookstoreapp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BookStoreAppServiceImpl implements IBookStoreAppService{

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    /***
     * Service Implementation for Add Customer to App using BookStoreApp Repository
     * @param customerRegisterDTO
     * @return
     */
    @Override
    public CustomerRegisterEntity addCustomer(CustomerRegisterDTO customerRegisterDTO) {
        CustomerRegisterEntity customerRegisterEntity = new CustomerRegisterEntity(customerRegisterDTO);
        customerRegisterEntity.setPassword(passwordEncoder.encode(customerRegisterDTO.getPassword()));
        return customerRepo.save(customerRegisterEntity);
    }
}
