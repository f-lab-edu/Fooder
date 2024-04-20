package com.ryumina.fooder.domain.store.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StoreSearchRequestDto {
    private String name;
    private String foodCategory;

    @PositiveOrZero(message = "page는 0 이상이어야 합니다")
    private int page = 0;

    @Min(value = 1, message = "size는 1 이상이어야 합니다")
    private int size = 10;

}
