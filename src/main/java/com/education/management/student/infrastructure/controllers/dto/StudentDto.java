package com.education.management.student.infrastructure.controllers.dto;

import jakarta.validation.constraints.*;

public class StudentDto {

    private String id;
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
    private Integer grade;

    @Size(min = 2)
    private String section;

    public StudentDto(String name, String email, Integer age, Integer grade, String section) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.grade = grade;
        this.section = section;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
