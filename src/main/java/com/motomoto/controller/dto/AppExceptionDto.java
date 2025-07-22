package com.motomoto.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppExceptionDto {
    private String errorCode;
    private String errorMessage;
    private String type;
    private String timestamp;
}
