package com.ryumina.fooder.infra.handler;

import com.ryumina.fooder.infra.Response;
import com.ryumina.fooder.infra.exception.FooderBusinessException;
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
