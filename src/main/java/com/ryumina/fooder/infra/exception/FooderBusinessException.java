package com.ryumina.fooder.infra.exception;

import lombok.Getter;

@Getter
public class FooderBusinessException extends RuntimeException {
    private final String resultMessage;

    public FooderBusinessException(String resultMessage) {
        super(resultMessage);
        this.resultMessage = resultMessage;
    }

    public FooderBusinessException(String resultMessage, Throwable throwable) {
        super(resultMessage, throwable);
        this.resultMessage = resultMessage;
    }
}
