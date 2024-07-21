package com.shailja.Customer_SpringBatch.config;

import com.shailja.Customer_SpringBatch.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor  implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception{
        return customer;
    }
}
