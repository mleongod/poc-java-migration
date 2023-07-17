package com.education.management.school.infrastructure.controllers;

import com.education.management.school.application.GetSchoolCollection;
import com.education.management.school.domain.School;
import com.education.management.school.infrastructure.controllers.dto.SchoolDto;
import com.education.management.shared.infrastructure.helpers.PathNames;
import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetSchoolCollectionController {

    private final GetSchoolCollection createSchool;

    private final SchoolMapper mapper;

    public GetSchoolCollectionController(GetSchoolCollection getSchoolCollection,
        SchoolMapper mapper) {
        this.createSchool = getSchoolCollection;
        this.mapper = mapper;
    }

    @GetMapping(PathNames.SCHOOL)
    public ResponseEntity<Collection<SchoolDto>> getSchoolCollection() {
        Collection<School> schoolCollection = this.createSchool.execute();
        Collection<SchoolDto> schoolList = schoolCollection.stream().map(this.mapper::toDto)
            .toList();
        return ResponseEntity.ok(schoolList);
    }
}
