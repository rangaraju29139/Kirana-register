package com.example.kiranaregister.services;

import com.example.kiranaregister.entities.Store;

import java.util.Optional;

/**
 * Abstraction for business login of store
 */
public interface StoreService {
    public Store createStore(Store store);
    public Optional<Store> getStore(long storeId);
}
