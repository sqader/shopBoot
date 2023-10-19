package com.example.shop.customer.controller;

import com.example.shop.customer.dto.CreateOrUpdateCustomerDto;
import com.example.shop.customer.dto.CustomerDto;
import com.example.shop.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }
    @GetMapping
    public List<CustomerDto> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public CustomerDto getById(@PathVariable Integer id){
        return service.findById(id);
    }
    @GetMapping(params = {"id"})
    public CustomerDto getByIdWithAttribute(@RequestParam("id") Integer id){
        return service.findById(id);
    }
    @PostMapping
    public CustomerDto createCustomer(@RequestBody CreateOrUpdateCustomerDto newCustomer){
        return service.save(newCustomer);
    }
    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Integer id, @RequestBody CreateOrUpdateCustomerDto customer){
        return service.update(id, customer);
    }
}
