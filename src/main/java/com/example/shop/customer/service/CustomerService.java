package com.example.shop.customer.service;



import com.example.shop.customer.dto.CreateOrUpdateCustomerDto;
import com.example.shop.customer.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAll();

    CustomerDto findById(Integer id);

    CustomerDto save(CreateOrUpdateCustomerDto newCustomer);

    CustomerDto update(Integer id, CreateOrUpdateCustomerDto customer);

}
