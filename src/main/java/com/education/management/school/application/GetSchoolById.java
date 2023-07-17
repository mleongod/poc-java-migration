package com.education.management.school.application;

import com.education.management.school.domain.School;
import com.education.management.school.domain.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetSchoolById {
    private final SchoolRepository schoolRepository;

    public GetSchoolById(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School execute(UUID uuid) {
        School school = this.schoolRepository.getById(uuid);
        return school;
    }
}
