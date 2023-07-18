package com.education.management.student.infrastructure.persistence.postgre;

import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpringDataStudentJpaRepository extends JpaRepository<StudentPostgreModel, UUID> {
  @Query(
      "SELECT s FROM StudentPostgreModel s WHERE s.level = :level")
  Collection<StudentPostgreModel> findUsersByLevel(Integer level);
}
