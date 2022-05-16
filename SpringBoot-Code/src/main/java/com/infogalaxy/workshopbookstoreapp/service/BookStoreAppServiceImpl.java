package com.infogalaxy.workshopbookstoreapp.service;

import com.infogalaxy.workshopbookstoreapp.dto.CustomerRegisterDTO;
import com.infogalaxy.workshopbookstoreapp.entity.CustomerRegisterEntity;
import com.infogalaxy.workshopbookstoreapp.repository.CustomerRepo;
import com.infogalaxy.workshopbookstoreapp.util.JMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class BookStoreAppServiceImpl implements IBookStoreAppService{

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    @Autowired
    JMSUtil jmsUtil;
    /***
     * Service Implementation for Add Customer to App using BookStoreApp Repository
     * @param customerRegisterDTO
     * @return
     */
    @Override
    public CustomerRegisterEntity addCustomer(CustomerRegisterDTO customerRegisterDTO) {
        CustomerRegisterEntity customerRegisterEntity = new CustomerRegisterEntity(customerRegisterDTO);
        customerRegisterEntity.setPassword(passwordEncoder.encode(customerRegisterDTO.getPassword()));
        int random = ThreadLocalRandom.current().nextInt(100000, 1000000);
        jmsUtil.sendMail(customerRegisterDTO.getEmailId(),"OTP for Addressbook App Login","Hello "+customerRegisterDTO.getFirstName()+", OTP for Your Addressbook App is : "+random);
        return customerRepo.save(customerRegisterEntity);
    }
}
