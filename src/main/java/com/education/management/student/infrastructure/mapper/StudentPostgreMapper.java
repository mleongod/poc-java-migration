package com.education.management.student.infrastructure.mapper;

import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.persistence.postgre.StudentPostgreModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentPostgreMapper {

  StudentPostgreModel toPersistence(Student student);

  Student toEntity(StudentPostgreModel model);
}
