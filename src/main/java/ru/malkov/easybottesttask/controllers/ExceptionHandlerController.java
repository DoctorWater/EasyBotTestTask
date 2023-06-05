package ru.malkov.easybottesttask.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.malkov.easybottesttask.dtos.ExceptionDto;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ProductTypeCastException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionDto handleException(ProductTypeCastException e) {
        return new ExceptionDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handleException() {
        return new ExceptionDto("Element you tried to find does not exist", HttpStatus.BAD_REQUEST);
    }
}