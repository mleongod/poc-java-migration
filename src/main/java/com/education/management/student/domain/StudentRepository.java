package com.education.management.student.domain;

import com.education.management.shared.infrastructure.exceptions.NotFoundException;

import java.util.Collection;
import java.util.UUID;

public interface StudentRepository {
    void create(Student student);

    Student getById(UUID id) throws NotFoundException;

    Collection<Student> getByLevel(Integer level);
}
