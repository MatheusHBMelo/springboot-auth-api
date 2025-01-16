package com.theus.auth_api.user.controller;

import com.theus.auth_api.user.controller.dto.UpdateRequestDTO;
import com.theus.auth_api.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/edit")
    public ResponseEntity<Void> updateUser(@AuthenticationPrincipal UserDetails loggedUser,
                                           @Valid @RequestBody UpdateRequestDTO updateRequestDTO) {
        userService.updateUser(loggedUser.getUsername(), updateRequestDTO);
        return ResponseEntity.noContent().build();
    }
}
