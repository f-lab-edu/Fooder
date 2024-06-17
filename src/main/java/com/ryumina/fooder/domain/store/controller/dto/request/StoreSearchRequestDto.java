package com.ryumina.fooder.domain.store.controller.dto.request;

import lombok.Getter;

@Getter
public class StoreSearchRequestDto extends PageRequestDto {
    private String foodCategory;

    public StoreSearchRequestDto(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public StoreSearchRequestDto(String foodCategory, int page, int size) {
        super(page, size);
        this.foodCategory = foodCategory;
    }
}
