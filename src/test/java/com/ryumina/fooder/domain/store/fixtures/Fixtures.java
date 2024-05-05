package com.ryumina.fooder.domain.store.fixtures;

import com.ryumina.fooder.domain.store.model.Address;
import com.ryumina.fooder.domain.store.model.FoodCategory;
import com.ryumina.fooder.domain.store.model.OpeningTime;
import com.ryumina.fooder.domain.store.model.entity.Store;
import com.ryumina.fooder.domain.store.model.entity.Store.StoreBuilder;

import java.time.LocalTime;

public class Fixtures {
    public static StoreBuilder aNotOpenStore() {
        return Store.builder()
                    .id(1L)
                    .name("푸더치킨")
                    .foodCategory(FoodCategory.CHICKEN)
                    .telephoneNumber("01012345678")
                    .address(Address.builder().zipCode("00123").address("서울특별시 강남구 강남대로 14").detailAddress("푸더빌딩 5층").build())
                    .minOrderPrice(12000)
                    .deliveryPrice(2500)
                    .openingTime(OpeningTime.builder().startTime(LocalTime.of(9, 0)).finishTime(LocalTime.of(16, 0)).build());
    }

    public static StoreBuilder aOpenStore() {
        return Store.builder()
                    .id(1L)
                    .name("푸더치킨")
                    .foodCategory(FoodCategory.CHICKEN)
                    .telephoneNumber("01012345678")
                    .address(Address.builder().zipCode("00123").address("서울특별시 강남구 강남대로 14").detailAddress("푸더빌딩 5층").build())
                    .minOrderPrice(12000)
                    .deliveryPrice(2500)
                    .openingTime(OpeningTime.builder().startTime(LocalTime.of(11, 0)).finishTime(LocalTime.of(23, 0)).build());
    }

}
