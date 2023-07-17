package com.education.management.school.infrastructure.controllers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SchoolDto {

    @NotEmpty()
    @Size(min = 2)
    private String name;

    @NotEmpty()
    @Email()
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
