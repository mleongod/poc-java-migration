package com.education.management.student.infrastructure.persistence.memory;

import com.education.management.shared.infrastructure.persistence.inmemory.CrudRepository;
import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentInMemoryRepository;
import jakarta.annotation.PostConstruct;
import java.util.Collection;
import java.util.Objects;
import org.springframework.stereotype.Repository;

@Repository
public class StudentInMemoryInMemoryRepositoryImplementation extends CrudRepository<Student>
    implements StudentInMemoryRepository {
  public StudentInMemoryInMemoryRepositoryImplementation() {
    super(Student.class.getSimpleName());
  }

  @Override
  public Collection<Student> getByLevel(Integer level) {
    return this.rows.values().stream()
        .filter(student -> Objects.equals(student.getLevel(), level))
        .toList();
  }

  @PostConstruct
  public void init() {
    for (int i = 0; i < 10; i++) {
      Student student =
          new Student(
              String.format("name %s", i),
              String.format("email%s@test.com", i),
              5 + i,
              1 + i,
              String.format("section-%s", i));
      this.create(student);
      System.out.printf("Student id: " + student.getId() + "\n");
    }
  }
}
