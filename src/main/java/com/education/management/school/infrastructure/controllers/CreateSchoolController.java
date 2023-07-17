package com.education.management.school.infrastructure.controllers;

import com.education.management.school.application.CreateSchool;
import com.education.management.school.domain.School;
import com.education.management.school.infrastructure.controllers.dto.SchoolDto;
import com.education.management.shared.infrastructure.helpers.PathNames;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CreateSchoolController {

    private final CreateSchool createSchool;
    private final SchoolMapper mapper;

    public CreateSchoolController(CreateSchool createSchool, SchoolMapper mapper) {
        this.createSchool = createSchool;
        this.mapper = mapper;
    }

    @PostMapping(PathNames.SCHOOL)
    public ResponseEntity<SchoolDto> create(@Valid @RequestBody SchoolDto dto) {
        School school = this.mapper.toEntity(dto);
        createSchool.execute(school);
        SchoolDto schoolDto = this.mapper.toDto(school);
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolDto);
    }
}
