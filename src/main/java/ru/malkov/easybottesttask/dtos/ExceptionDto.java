package ru.malkov.easybottesttask.dtos;

import org.springframework.http.HttpStatus;

public record ExceptionDto(String message, HttpStatus status) {
}