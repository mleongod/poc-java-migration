package com.education.management.student.infrastructure.mapper;

import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
  @Mapping(target="grade", source="level")
  StudentDto toDto(Student student);

  @Mapping(target="level", source="grade")
  Student toEntity(StudentDto studentDto);
}
