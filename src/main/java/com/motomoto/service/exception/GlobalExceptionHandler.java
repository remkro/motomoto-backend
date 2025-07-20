package com.motomoto.service.exception;

import com.motomoto.controller.dto.AppExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static com.motomoto.service.exception.ExceptionCategory.BUSINESS;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<AppExceptionDto> handleUserAlreadyExists(UserAlreadyExistsException e) {
        AppExceptionDto error = new AppExceptionDto(
                e.errorCode().getShortName(),
                e.getMessage(),
                BUSINESS.getShortName(),
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}