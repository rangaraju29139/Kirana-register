package com.example.kiranaregister.dtos.store;

import com.example.kiranaregister.entities.Store;

public class StoreRequestDtoMapper {

    /**
     * Mapping to get the required details form the StoreRequestDto  and map it to the actual store object
     * @param storeRequestDto
     * @return
     */
    public static Store mapToStore(StoreRequestDto storeRequestDto){
        return Store.builder()
                .address(storeRequestDto.getAddress())
                .name(storeRequestDto.getName())
                .balance(storeRequestDto.getBalance())
                .description(storeRequestDto.getDescription())
                .operationalCurrency(storeRequestDto.getOperationalCurrency())
                .balance(0.0)
                .build();
    }
}
