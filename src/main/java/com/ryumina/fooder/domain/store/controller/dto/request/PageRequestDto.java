package com.ryumina.fooder.domain.store.controller.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

@Getter
public class PageRequestDto {
    @PositiveOrZero(message = "page는 0 이상이어야 합니다")
    private int page = 0;

    @Min(value = 1, message = "size는 1 이상이어야 합니다")
    private int size = 10;

    public PageRequestDto() {
    }

    public PageRequestDto(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
