package com.education.management.school.infrastructure.controllers;

import com.education.management.school.application.GetSchoolCollection;
import com.education.management.school.domain.School;
import com.education.management.shared.infrastructure.helpers.PathNames;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GetSchoolCollectionController {

    private final GetSchoolCollection createSchool;

    public GetSchoolCollectionController(GetSchoolCollection getSchoolCollection) {
        this.createSchool = getSchoolCollection;
    }

    @GetMapping(PathNames.SCHOOL)
    public ResponseEntity<Collection<School>> getSchoolCollection() {
        Collection<School> schoolCollection = this.createSchool.execute();
        return ResponseEntity.ok(schoolCollection);
    }
}
