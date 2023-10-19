package com.example.shop.customer.repository;




import com.example.shop.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
