package com.ryumina.fooder.domain.store.controller.dto.response;

import com.ryumina.fooder.domain.store.model.entity.Store;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class SearchStoresResponseDto {
    private final Long id;
    private final String name;
    private final boolean open;
    private final String foodCategory;
    private final String telephoneNumber;
    private final String zipCode;
    private final String address;
    private final String detailAddress;
    private final int minOrderPrice;
    private final int deliveryPrice;
    private final LocalTime startTime;
    private final LocalTime finishTime;

    @Builder
    public SearchStoresResponseDto(Long id, String name, boolean open, String foodCategory, String telephoneNumber,
                                   String zipCode, String address, String detailAddress, int minOrderPrice, int deliveryPrice,
                                   LocalTime startTime, LocalTime finishTime) {
        this.id = id;
        this.name = name;
        this.open = open;
        this.foodCategory = foodCategory;
        this.telephoneNumber = telephoneNumber;
        this.zipCode = zipCode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.minOrderPrice = minOrderPrice;
        this.deliveryPrice = deliveryPrice;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public static SearchStoresResponseDto from(Store store) {
        return SearchStoresResponseDto.builder()
                                      .id(store.getId())
                                      .name(store.getName())
                                      .open(store.isOpen())
                                      .foodCategory(store.getFoodCategory().toString())
                                      .telephoneNumber(store.getTelephoneNumber())
                                      .zipCode(store.getAddress().getZipCode())
                                      .address(store.getAddress().getAddress())
                                      .detailAddress(store.getAddress().getDetailAddress())
                                      .minOrderPrice(store.getMinOrderPrice())
                                      .deliveryPrice(store.getDeliveryPrice())
                                      .startTime(store.getOpeningTime().getStartTime())
                                      .finishTime(store.getOpeningTime().getFinishTime())
                                      .build();
    }

}

