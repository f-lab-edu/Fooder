package com.ryumina.fooder.infra.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PageRequestDto {
    @PositiveOrZero(message = "page는 0 이상이어야 합니다")
    private int page = 0;

    @Min(value = 1, message = "size는 1 이상이어야 합니다")
    private int size = 10;

}
