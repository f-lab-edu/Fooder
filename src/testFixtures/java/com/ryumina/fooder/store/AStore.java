package com.ryumina.fooder.store;

import com.ryumina.fooder.domain.store.model.Address;
import com.ryumina.fooder.domain.store.model.FoodCategory;
import com.ryumina.fooder.domain.store.model.OpeningTime;
import com.ryumina.fooder.domain.store.model.entity.Store;

import java.time.LocalTime;

public class AStore {
    public static Store.StoreBuilder aNotOpenStore() {
        return Store.builder()
                    .name("푸더치킨")
                    .foodCategory(FoodCategory.CHICKEN)
                    .telephoneNumber("01012345678")
                    .address(Address.builder().zipCode("00123").address("서울특별시 강남구 강남대로 14").detailAddress("푸더빌딩 5층").build())
                    .minOrderPrice(12000)
                    .deliveryPrice(2500)
                    .openingTime(OpeningTime.builder().startTime(LocalTime.of(4, 0)).finishTime(LocalTime.of(4, 1)).build());
    }

    public static Store.StoreBuilder aOpenStore() {
        return Store.builder()
                    .name("푸더치킨")
                    .foodCategory(FoodCategory.CHICKEN)
                    .telephoneNumber("01012345678")
                    .address(Address.builder().zipCode("00123").address("서울특별시 강남구 강남대로 14").detailAddress("푸더빌딩 5층").build())
                    .minOrderPrice(12000)
                    .deliveryPrice(2500)
                    .openingTime(OpeningTime.builder().startTime(LocalTime.of(0, 0)).finishTime(LocalTime.of(23, 59, 59)).build());
    }
}
