package com.motomoto.service.exception;

public class UserAlreadyExistsException extends GenericException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public ExceptionErrorCode errorCode() {
        return ExceptionErrorCode.technical("user-already-exists");
    }
}
