package com.motomoto.controller.user;

import com.motomoto.controller.dto.StatusResponseDto;
import com.motomoto.controller.user.dto.CreateUserRequestDto;
import com.motomoto.dao.model.user.User;
import com.motomoto.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<StatusResponseDto> create(@Valid @RequestBody CreateUserRequestDto request) {
        log.info("Received request to create user, first name: {}, last name: {}, email: {}",
                request.getFirstName(),
                request.getLastName(),
                request.getEmail()
        );

        User user = userService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        StatusResponseDto.builder()
                                .status("User created, id: " + user.getId())
                                .timestamp(Instant.now())
                                .build()
                );
    }
}
