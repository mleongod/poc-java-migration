package com.education.management.student.infrastructure.persistence.mongo;

import com.education.management.shared.infrastructure.exceptions.NotFoundException;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.mapper.StudentMongoMapper;
import com.education.management.student.repositories.StudentMongoRepository;
import java.util.Collection;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class StudentMongoRepositoryImplementation implements StudentMongoRepository {
  private final SpringDataStudentMongoRepository repository;
  private final StudentMongoMapper mapper;

  @Override
  public void create(Student student) {
  StudentMongoModel  studentMongoModel = mapper.toPersistence(student);
    this.repository.save(studentMongoModel);
  }

  @Override
  public Student getById(UUID id) throws NotFoundException {
    StudentMongoModel studentMongoModel = this.repository.findById(id).orElseThrow(() -> NotFoundException.create(
        String.format("Student %s not found", id)));
    return this.mapper.toEntity(studentMongoModel);
  }

  @Override
  public Collection<Student> getByLevel(Integer level) {
    Collection<StudentMongoModel> studentMongoModels = this.repository.findUsersByLevel(level);
    return studentMongoModels.stream().map(mapper::toEntity).toList();
  }
}
