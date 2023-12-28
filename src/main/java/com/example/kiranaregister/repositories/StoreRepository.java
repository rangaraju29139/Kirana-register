package com.example.kiranaregister.repositories;

import com.example.kiranaregister.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository helps to get the Store data from the database.
 */
public interface StoreRepository extends JpaRepository<Store,Long> {


}
