package com.motomoto.service.exception;

import lombok.Data;

import static com.motomoto.service.exception.ExceptionCategory.BUSINESS;
import static com.motomoto.service.exception.ExceptionCategory.TECHNICAL;

@Data
public class ExceptionErrorCode {
    private final String shortName;
    private final ExceptionCategory category;

    public static ExceptionErrorCode somethingWentWrong() {
        return new ExceptionErrorCode("something-went-wrong", TECHNICAL);
    }

    public static ExceptionErrorCode business(String shortName) {
        return new ExceptionErrorCode(shortName, BUSINESS);
    }

    public static ExceptionErrorCode technical(String shortName) {
        return new ExceptionErrorCode(shortName, TECHNICAL);
    }
}
