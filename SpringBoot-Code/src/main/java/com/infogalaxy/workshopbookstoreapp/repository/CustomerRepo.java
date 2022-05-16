package com.infogalaxy.workshopbookstoreapp.repository;

import com.infogalaxy.workshopbookstoreapp.entity.CustomerRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerRegisterEntity, Long> {
    boolean findCustomerRegisterEntityByEmailId(String emailId);
}
