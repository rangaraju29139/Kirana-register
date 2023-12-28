package com.example.kiranaregister.dtos.store;

import com.example.kiranaregister.entities.Store;

public class StoreResponseDtoMapper {
    /**
     * Mapping to get the required details form the Store   and map it to the actual storeResponseDto object to achieve the abstraction
     * @param store
     * @return
     */
    public  static StoreResponseDto mapToStoreResponseDto(Store store){
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
