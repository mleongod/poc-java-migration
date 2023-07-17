package com.education.management.school.application;

import com.education.management.school.domain.SchoolRepository;
import com.education.management.school.infrastructure.controllers.dto.SchoolDto;
import org.springframework.stereotype.Service;

@Service
public class CreateSchool {
    private final SchoolRepository schoolRepository;

    public CreateSchool(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public void execute(SchoolDto schoolDto) {
//        School school = new School(schoolDto.getName(), schoolDto.getEmail());
//        this.schoolRepository.create(school);
       /// return school;
    }
}
