package com.ryumina.fooder.store.controller.dto.response;

import com.ryumina.fooder.store.domain.Store;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SearchStoresResponseDto {
    private Long id;
    private String name;
    private String foodCategory;
    private String telephoneNumber;
    private String zipCode;
    private String address;
    private String detailAddress;
    private String bizNumber;
    private Integer minOrderPrice;
    private Integer deliveryPrice;
    private String orderPossibleType;
    private String payPossibleType;
    private String status;
    private String startTime;
    private String finishTime;
    //    private String deliveryLocation;
    private String ownerNotification;

    public static SearchStoresResponseDto from(Store store) {
        return SearchStoresResponseDto.builder()
                                      .id(store.getId())
                                      .name(store.getName())
                                      .foodCategory(store.getFoodCategory())
                                      .telephoneNumber(store.getTelephoneNumber())
                                      .zipCode(store.getZipCode())
                                      .address(store.getAddress())
                                      .detailAddress(store.getDetailAddress())
                                      .bizNumber(store.getBizNumber())
                                      .minOrderPrice(store.getMinOrderPrice())
                                      .deliveryPrice(store.getDeliveryPrice())
                                      .orderPossibleType(store.getOrderPossibleType())
                                      .payPossibleType(store.getPayPossibleType())
                                      .status(store.getStatus())
                                      .startTime(store.getStartTime())
                                      .finishTime(store.getFinishTime())
                                      .ownerNotification(store.getOwnerNotification())
                                      .build();
    }
}

