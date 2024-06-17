package com.ryumina.fooder.common;

import lombok.Builder;
import lombok.Getter;

@Builder(builderMethodName = "innerBuilder")
@Getter
public class Response<T> {
    private String message;
    private T data;

    public static <T> ResponseBuilder<T> ok(T data) {
        ResponseBuilder<T> innerBuilder = innerBuilder();
        return innerBuilder.data(data);
    }

    public static <T> ResponseBuilder<T> fail(String fail) {
        ResponseBuilder<T> innerBuilder = innerBuilder();
        return innerBuilder.message(fail);
    }
}
