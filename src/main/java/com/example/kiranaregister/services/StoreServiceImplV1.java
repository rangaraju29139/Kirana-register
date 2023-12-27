package com.example.kiranaregister.services;


import com.example.kiranaregister.entities.Store;
import com.example.kiranaregister.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Qualifier("v1")
@Service
public class StoreServiceImplV1 implements StoreService{
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Optional<Store> getStore(long id) {
        return  storeRepository.findById(id);

    }

    @Override
    public Store createStore(Store store) {
        Store savedStore = storeRepository.save(store);
        return store;
    }
}
