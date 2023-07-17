package com.education.management.school.infrastructure.controllers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SchoolDto {

    private String id;

    @NotEmpty()
    @Size(min = 2)
    private String name;

    @NotEmpty()
    @Size(min = 3)
    private String direction;

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
