package com.education.management.student.repositories;

import com.education.management.shared.infrastructure.exceptions.NotFoundException;
import com.education.management.student.domain.Student;
import java.util.Collection;
import java.util.UUID;

public interface CommonRepositoryMethods{
  void create(Student student);

  Student getById(UUID id) throws NotFoundException;

  Collection<Student> getByLevel(Integer level);
}
