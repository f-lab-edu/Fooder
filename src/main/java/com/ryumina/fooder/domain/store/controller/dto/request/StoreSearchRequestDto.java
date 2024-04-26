package com.ryumina.fooder.domain.store.controller.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StoreSearchRequestDto extends PageRequestDto {
    private String name;
    private String foodCategory;

}
