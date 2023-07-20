package com.education.management.school.infrastructure.controllers;

import com.education.management.school.domain.School;
import com.education.management.school.infrastructure.controllers.dto.SchoolDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
  @Mapping(target="address", source="direction")
  School toEntity(SchoolDto schoolDto);
  @Mapping(target="direction", source="address")
  SchoolDto toDto(School school);
}
