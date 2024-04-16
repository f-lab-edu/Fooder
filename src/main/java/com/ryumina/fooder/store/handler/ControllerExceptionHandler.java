package com.ryumina.fooder.store.handler;

import com.ryumina.fooder.store.exception.FooderBusinessException;
import com.ryumina.fooder.store.infra.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {FooderBusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<?> fooderBusinessException(FooderBusinessException e) {
        return Response.builder(e.getResultCode(), e.getResultMessage()).data(StringUtils.EMPTY).build();
    }
}
