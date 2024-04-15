package com.ryumina.fooder.exception;

public class FooderBusinessException extends RuntimeException {

    public FooderBusinessException() {
    }

    public FooderBusinessException(String message) {
        super(message);
    }

    public FooderBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public FooderBusinessException(Throwable cause) {
        super(cause);
    }

    public FooderBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
