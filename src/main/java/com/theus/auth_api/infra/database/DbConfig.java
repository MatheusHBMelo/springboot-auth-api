package com.theus.auth_api.infra.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.theus.auth_api.user.model.User;
import com.theus.auth_api.user.model.UserRole;
import com.theus.auth_api.user.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DbConfig implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (this.userRepository.findByUsername("Matheus Henrique") == null) {
            var user = new User(null,
                    "Matheus Henrique",
                    "$2a$10$KOQmlrDYgVYGx0fhBr49tuBVgWiWQivkE7eEM9uJVhhv2ACingfNu",
                    UserRole.ADMIN);
            this.userRepository.save(user);
        }
    }
}
