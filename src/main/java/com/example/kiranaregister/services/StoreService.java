package com.example.kiranaregister.services;

import com.example.kiranaregister.entities.Store;

import java.util.Optional;

public interface StoreService {
    public Store createStore(Store store);
    public Optional<Store> getStore(long storeId);
}
