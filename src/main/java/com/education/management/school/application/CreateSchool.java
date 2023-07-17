package com.education.management.school.application;

import com.education.management.school.domain.School;
import com.education.management.school.domain.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateSchool {
    private final SchoolRepository schoolRepository;

    public CreateSchool(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public void execute(School school) {
        this.schoolRepository.create(school);
    }
}
