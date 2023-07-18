package com.education.management.school.application;

import com.education.management.school.domain.School;
import com.education.management.school.domain.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CreateSchool {
    private final SchoolRepository schoolRepository;

    public void execute(School school) {
        this.schoolRepository.create(school);
    }
}
