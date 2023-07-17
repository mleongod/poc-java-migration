package com.education.management.school.infrastructure.controllers;

import com.education.management.school.application.CreateSchool;
import com.education.management.school.domain.School;
import com.education.management.school.infrastructure.controllers.dto.SchoolDto;
import com.education.management.shared.infrastructure.helpers.PathNames;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CreateSchoolController {

    private final CreateSchool createSchool;

    public CreateSchoolController(CreateSchool createSchool) {
        this.createSchool = createSchool;
    }

    @PostMapping(PathNames.SCHOOL)
    public ResponseEntity<School> create(@Valid @RequestBody SchoolDto dto) {
        return ResponseEntity.ok().build();
    }
}
