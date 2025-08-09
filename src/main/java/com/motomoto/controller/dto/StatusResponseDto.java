package com.motomoto.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class StatusResponseDto {
    private String status;
    private Instant timestamp;
}
