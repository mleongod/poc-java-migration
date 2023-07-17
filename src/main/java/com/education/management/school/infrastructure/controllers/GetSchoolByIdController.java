package com.education.management.school.infrastructure.controllers;

import com.education.management.school.application.GetSchoolById;
import com.education.management.school.domain.School;
import com.education.management.school.infrastructure.controllers.dto.SchoolDto;
import com.education.management.shared.infrastructure.helpers.PathNames;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class GetSchoolByIdController {

    private final GetSchoolById getSchoolById;
    private final SchoolMapper mapper;


    public GetSchoolByIdController(GetSchoolById getSchoolCollection, SchoolMapper mapper) {
        this.getSchoolById = getSchoolCollection;
        this.mapper = mapper;
    }

    @GetMapping(PathNames.SCHOOL + "/{id}")
    public ResponseEntity<SchoolDto> getSchoolById(@PathVariable("id") @Valid @Size(min = 36) String id) {
        School school = this.getSchoolById.execute(UUID.fromString(id));
        SchoolDto schoolDto = this.mapper.toDto(school);
        return ResponseEntity.ok(schoolDto);
    }
}
