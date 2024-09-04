package com.theus.auth_api.user.controller;

import com.theus.auth_api.user.dto.LoginDTO;
import com.theus.auth_api.user.dto.RegisterDTO;
import com.theus.auth_api.user.model.User;
import com.theus.auth_api.user.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody @Valid LoginDTO loginDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO registerDTO) {
        if (this.userRepository.findByUsername(registerDTO.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        var encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User(null, registerDTO.username(), encryptedPassword, registerDTO.role());
        this.userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
