package com.education.management.student.infrastructure.persistence.mongo;

import java.util.Collection;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SpringDataStudentMongoRepository extends MongoRepository<StudentMongoModel, UUID> {
  @Query("{ 'level' : ?0 }")
  Collection<StudentMongoModel> findUsersByLevel(Integer level);
}
