package com.example.kiranaregister.services;

import com.example.kiranaregister.dtos.store.StoreResponseDto;
import com.example.kiranaregister.entities.Store;

public interface StoreService {
    public Store createStore(Store store);
    public Store getStore(long id);
}
