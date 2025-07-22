package com.motomoto.service.exception;

public abstract class GenericException extends RuntimeException {
    public GenericException(String message) {
        super(message);
    }

    public abstract ExceptionErrorCode errorCode();
}
