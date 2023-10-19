package com.example.shop.customer.service;

import com.example.shop.customer.dto.CreateOrUpdateCustomerDto;
import com.example.shop.customer.dto.CustomerDto;
import com.example.shop.customer.mapper.CustomerMapper;
import com.example.shop.customer.model.Customer;
import com.example.shop.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository repository;

    private CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<CustomerDto> findAll() {
        return mapper.mapTodto(repository.findAll());
    }

    @Override
    public CustomerDto findById(Integer id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer with given id does not exists"));
        return mapper.mapToDto(customer);
    }

    @Override
    public CustomerDto save(CreateOrUpdateCustomerDto newCustomer) {
        Customer customer = mapper.mapTo(newCustomer);
        customer = repository.save(customer);
        return mapper.mapToDto(customer);
    }

    @Override
    public CustomerDto update(Integer id, CreateOrUpdateCustomerDto newCustomer) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity with id found"));
        customer = mapper.mapTo(customer, newCustomer);
        repository.save(customer);
        return mapper.mapToDto(customer);
    }
}
