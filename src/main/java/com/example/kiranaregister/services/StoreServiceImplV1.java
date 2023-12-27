package com.example.kiranaregister.services;


import com.example.kiranaregister.dtos.store.StoreResponseDto;
import com.example.kiranaregister.entities.Store;
import com.example.kiranaregister.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("v1")
@Service
public class StoreServiceImplV1 implements StoreService{
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store getStore(long id) {
        return null;
    }

    @Override
    public Store createStore(Store store) {
        Store savedStore = storeRepository.save(store);
        return store;
    }
}
