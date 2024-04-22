package com.ryumina.fooder.domain.store.dto.request;

import com.ryumina.fooder.infra.dto.PageRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StoreSearchRequestDto extends PageRequestDto {
    private String name;
    private String foodCategory;

}
