package com.education.management.student.infrastructure.mapper;

import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.persistence.mongo.StudentMongoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMongoMapper {

  StudentMongoModel toPersistence(Student student);

  Student toEntity(StudentMongoModel mongoModel);
}
