package com.education.management.school.domain;

import com.education.management.shared.domain.AggregateRoot;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;

@Getter
public class School extends AggregateRoot {
    private final String name;
    private final String email;

    public School(UUID id, Date createdAt, Date updatedAt, String name, String email) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.email = email;
    }
}