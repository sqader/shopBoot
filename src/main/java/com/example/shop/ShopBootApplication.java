package com.example.shop;

import com.example.shop.customer.dto.CustomerDto;
import com.example.shop.customer.model.Customer;
import com.example.shop.customer.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ShopBootApplication {

    public static void main(String[] args) {


        SpringApplication.run(ShopBootApplication.class, args);

    }

}
