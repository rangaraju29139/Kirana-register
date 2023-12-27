package com.example.kiranaregister.repositories;

import com.example.kiranaregister.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
