package com.education.management.school.domain;

import com.education.management.shared.infrastructure.exceptions.NotFoundException;

import java.util.Collection;
import java.util.UUID;

public interface SchoolRepository {
    void create(School school);

    School getById(UUID id) throws NotFoundException;

    Collection<School> getAll();
}
