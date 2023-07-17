package com.education.management.school.infrastructure.controllers;

import com.education.management.school.application.GetSchoolById;
import com.education.management.school.domain.School;
import com.education.management.shared.infrastructure.helpers.PathNames;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class GetSchoolByIdController {

    private final GetSchoolById getSchoolById;

    public GetSchoolByIdController(GetSchoolById getSchoolCollection) {
        this.getSchoolById = getSchoolCollection;
    }

    @GetMapping(PathNames.SCHOOL + "/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable("id") @NotBlank @UUID(version = 4) java.util.UUID id) {
        School school = this.getSchoolById.execute(id);
        return ResponseEntity.ok(school);
    }
}
