package com.motomoto.service.exception;

import com.motomoto.controller.dto.AppExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.motomoto.service.exception.ExceptionCategory.BUSINESS;
import static com.motomoto.service.exception.ExceptionCategory.TECHNICAL;
import static com.motomoto.service.exception.ExceptionErrorCode.somethingWentWrong;
import static java.time.LocalDateTime.now;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<AppExceptionDto> handleUserAlreadyExists(UserAlreadyExistsException e) {
        log.error("Exception: {} at: {}", ExceptionUtils.getStackTrace(e), now());

        AppExceptionDto error = new AppExceptionDto(
                e.errorCode().getShortName(),
                e.getMessage(),
                BUSINESS.getShortName(),
                now().toString()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppExceptionDto> handleOtherException(Exception e) {
        log.error("Exception: {} at: {}", ExceptionUtils.getStackTrace(e), now());

        return ResponseEntity
                .internalServerError()
                .body(new AppExceptionDto(
                        somethingWentWrong().getShortName(),
                        "Something went wrong",
                        TECHNICAL.getShortName(),
                        now().toString())
                );
    }
}