package com.training.micro.error;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    private static final String TRAINING = "training";
    private static final String SPRINGPROJ = "springproj";

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleError(final IllegalArgumentException exceptionParam) {
        return new ErrorObject().setMicroservice(SPRINGPROJ)
                                .setBoundedContext(TRAINING)
                                .setDesc("Error : " + exceptionParam.getMessage())
                                .setCause(1000);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleError(final MethodArgumentNotValidException exceptionParam) {
        ErrorObject e = new ErrorObject().setMicroservice(SPRINGPROJ)
                                         .setBoundedContext(TRAINING)
                                         .setDesc("Validation Error")
                                         .setCause(2000);
        List<ObjectError> allErrorsLoc = exceptionParam.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            e.addSubErrors(new ErrorObject().setMicroservice(SPRINGPROJ)
                                            .setBoundedContext(TRAINING)
                                            .setDesc(objectErrorLoc.toString())
                                            .setCause(2001));
        }
        return e;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObject handleError(final Exception exceptionParam) {
        return new ErrorObject().setMicroservice(SPRINGPROJ)
                                .setBoundedContext(TRAINING)
                                .setDesc("Critical Error : " + exceptionParam.getMessage())
                                .setCause(9000);
    }

}
