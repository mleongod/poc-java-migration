package com.education.management.student.infrastructure.persistence;

import com.education.management.shared.infrastructure.persistence.CrudRepository;
import com.education.management.student.domain.Student;
import com.education.management.student.domain.StudentRepository;
import jakarta.annotation.PostConstruct;
import java.util.Collection;
import java.util.Objects;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImplementation extends CrudRepository<Student>
    implements StudentRepository {
  public StudentRepositoryImplementation() {
    super(Student.class.getName());
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
