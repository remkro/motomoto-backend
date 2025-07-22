package com.motomoto.service.user;

import com.motomoto.controller.user.dto.CreateUserRequestDto;
import com.motomoto.dao.model.user.User;
import com.motomoto.dao.repository.UserRepository;
import com.motomoto.service.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void create(CreateUserRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User with email " + request.getEmail() + " already exists");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDisplayName(extractDisplayName(request.getEmail()));
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setActive(true);
        user.setCreatedBy("REGISTRATION_PROCESS");

        userRepository.save(user);
    }

    private String extractDisplayName(String email) {
        return email.substring(0, email.indexOf("@"));
    }
}
