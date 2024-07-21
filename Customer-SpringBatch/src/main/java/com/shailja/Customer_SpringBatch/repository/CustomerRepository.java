package com.shailja.Customer_SpringBatch.repository;

import com.shailja.Customer_SpringBatch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
