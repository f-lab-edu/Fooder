package com.ryumina.fooder.infra;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(builderMethodName = "innerBuilder")
@ToString
public class Response<T> {

    @NotNull
    private String code;

    @NotNull
    private String message;

    private T data;

    public static <T> ResponseBuilder<T> builder(String code, String message) {
        ResponseBuilder<T> innerBuilder = innerBuilder();

        return innerBuilder.code(code).message(message);
    }

}
