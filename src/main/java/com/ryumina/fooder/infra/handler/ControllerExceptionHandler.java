package com.ryumina.fooder.infra.handler;

import com.ryumina.fooder.infra.FailResult;
import com.ryumina.fooder.infra.Response;
import com.ryumina.fooder.infra.exception.FooderBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    // parameter binding fail
    @ExceptionHandler(value = {
        MethodArgumentTypeMismatchException.class,
        BindException.class,
        HttpMessageNotReadableException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<?> wrongParameterException(HttpMessageNotReadableException e) {
        return Response.fail(FailResult.WRONG_PARAMETER_EXCEPTION.getMessage()).build();
    }

    // parameter validation check fail
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<?> methodArgumentTypeMismatchException(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        String message = objectError.getDefaultMessage();

        return Response.fail(((FieldError) objectError).getField() + ": " + message).build();
    }

    // business fail
    @ExceptionHandler(value = {FooderBusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<?> fooderBusinessException(FooderBusinessException e) {
        return Response.fail(e.getResultMessage()).build();
    }

}
