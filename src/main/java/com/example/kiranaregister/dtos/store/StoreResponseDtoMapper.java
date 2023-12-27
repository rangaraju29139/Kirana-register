package com.example.kiranaregister.dtos.store;

import com.example.kiranaregister.entities.Store;

public class StoreResponseDtoMapper {
    public StoreResponseDto mapToStoreResponseDto(Store store){
        return StoreResponseDto.builder()
                .id(store.getId())
                .storeOwnerId(store.getStoreOwner().getId())
                .balance(store.getBalance())
                .description(store.getDescription())
                .address(store.getAddress())
                .operationalCurrency(store.getOperationalCurrency())
                .name(store.getName())
                .build();
    }
}
