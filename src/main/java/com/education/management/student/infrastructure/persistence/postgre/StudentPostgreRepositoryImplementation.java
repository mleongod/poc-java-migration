package com.education.management.student.infrastructure.persistence.postgre;

import com.education.management.shared.infrastructure.exceptions.NotFoundException;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.mapper.StudentPostgreMapper;
import com.education.management.student.repositories.StudentPostgreRepository;
import java.util.Collection;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentPostgreRepositoryImplementation implements StudentPostgreRepository {
  private final SpringDataStudentJpaRepository repository;
  private final StudentPostgreMapper mapper;

  @Override
  public void create(Student student) {
    StudentPostgreModel model = mapper.toPersistence(student);
    this.repository.save(model);
  }

  @Override
  public Student getById(UUID id) throws NotFoundException {
    StudentPostgreModel model = this.repository.findById(id).orElseThrow(() -> NotFoundException.create(
        String.format("Student %s not found", id)));
    return this.mapper.toEntity(model);
  }

  @Override
  public Collection<Student> getByLevel(Integer level) {
    Collection<StudentPostgreModel> models = this.repository.findUsersByLevel(level);
    return models.stream().map(mapper::toEntity).toList();
  }
}
