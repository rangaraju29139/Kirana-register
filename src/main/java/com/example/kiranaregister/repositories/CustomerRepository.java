package com.example.kiranaregister.repositories;

import com.example.kiranaregister.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository help to access the Customer info from the database
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
