package com.theus.auth_api.user.service;

import com.theus.auth_api.product.service.exceptions.ObjectNotFoundException;
import com.theus.auth_api.user.controller.dto.UpdateRequestDTO;
import com.theus.auth_api.user.model.User;
import com.theus.auth_api.user.repositories.UserRepository;
import com.theus.auth_api.user.service.exceptions.PasswordIncorrectException;
import com.theus.auth_api.user.service.exceptions.UsernameIncorrectException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void updateUser(String loggedUsername, UpdateRequestDTO updateRequestDTO) {
        validateUpdate(loggedUsername, updateRequestDTO);

        var user = (User) userRepository.findByUsername(loggedUsername);

        if (user == null) {
            throw new ObjectNotFoundException("User not found for username: " + loggedUsername);
        }

        if (!passwordEncoder.matches(updateRequestDTO.currentPassword(), user.getPassword())) {
            throw new PasswordIncorrectException("Current password is incorrect!");
        }

        if (updateRequestDTO.newUsername() != null) {
            user.setUsername(updateRequestDTO.newUsername());
        }

        if (updateRequestDTO.newPassword() != null) {
            user.setPassword(passwordEncoder.encode(updateRequestDTO.newPassword()));
        }

        userRepository.save(user);
    }

    private void validateUpdate(String loggedUsername, UpdateRequestDTO updateRequestDTO) {
        if (!loggedUsername.equals(updateRequestDTO.currentUsername())) {
            throw new UsernameIncorrectException("You can only update your own account!");
        }
    }
}
