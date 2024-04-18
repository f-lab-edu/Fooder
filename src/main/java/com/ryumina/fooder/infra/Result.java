package com.ryumina.fooder.infra;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Result {
    SUCCESS("0000", "정상 처리되었습니다."),
    FAIL("0002", "실패 처리되었습니다."),
    NO_RESULT("0003", "결과가 없습니다."),
    UNKNOWN_EXCEPTION("9999", "알 수 없는 오류가 발생했습니다.");

    private final String code;
    private final String message;

}
