package com.education.management.student.infrastructure.controllers.dto;

import jakarta.validation.constraints.*;

public class StudentDto {
    @NotEmpty
    @Size(min = 2)
    private String name;

    @Email
    private String email;

    @NotNull
    @Min(value = 5)
    private Integer age;


    @Min(value = 1)
    @Max(value = 10)
    private Integer level;

    @Size(min = 2)
    private String section;

    public StudentDto(String name, String email, Integer age, Integer level, String section) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.level = level;
        this.section = section;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
