package ru.malkov.easybottesttask.exceptions;

public class ProductTypeCastException extends Exception {
    public ProductTypeCastException(Throwable cause) {
        super("An error occurred during product cast to concrete product.", cause);
    }
}