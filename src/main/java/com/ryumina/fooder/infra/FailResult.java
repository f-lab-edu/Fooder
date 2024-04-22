package com.ryumina.fooder.infra;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FailResult {
    NO_RESULT("결과가 없습니다."),
    WRONG_PARAMETER_EXCEPTION("잘못된 매개변수입니다."),
    UNKNOWN_EXCEPTION("알 수 없는 오류가 발생했습니다.");

    private final String message;

}
