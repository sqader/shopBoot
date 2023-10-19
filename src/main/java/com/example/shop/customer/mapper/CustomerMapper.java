package com.example.shop.customer.mapper;

import com.example.shop.customer.dto.CreateOrUpdateCustomerDto;
import com.example.shop.customer.dto.CustomerDto;
import com.example.shop.customer.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerDto mapToDto(Customer customer){
        var customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        return customerDto;
    }

    public List<CustomerDto> mapTodto(Collection<Customer> customers){
        return customers.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Customer mapTo(CreateOrUpdateCustomerDto newCustomer) {
        var customer = new Customer();
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        return customer;
    }

    public Customer mapTo(Customer customer, CreateOrUpdateCustomerDto newCustomer) {
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        return customer;
    }
}
