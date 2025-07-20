package com.motomoto.controller.user.dto;

import lombok.Data;

@Data
public class CreateUserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
