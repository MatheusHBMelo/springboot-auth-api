package com.theus.auth_api.user.enums;

public enum UserRole {
    USER("USER"),
    ADMIN("ADMIN");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
