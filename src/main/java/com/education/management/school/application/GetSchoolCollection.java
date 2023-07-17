package com.education.management.school.application;

import com.education.management.school.domain.School;
import com.education.management.school.domain.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GetSchoolCollection {
    private final SchoolRepository schoolRepository;

    public GetSchoolCollection(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public Collection<School> execute() {
        Collection<School> schoolCollection = this.schoolRepository.getAll();
        return schoolCollection;
    }
}
