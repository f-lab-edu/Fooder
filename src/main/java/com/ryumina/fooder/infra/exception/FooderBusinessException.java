package com.ryumina.fooder.infra.exception;

import lombok.Getter;

@Getter
public class FooderBusinessException extends RuntimeException {

    private final String resultCode;
    private final String resultMessage;

    public FooderBusinessException(String resultCode, String resultMessage) {
        super(resultMessage);
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public FooderBusinessException(String resultCode, String resultMessage, Throwable throwable) {
        super(resultMessage, throwable);
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }
}
