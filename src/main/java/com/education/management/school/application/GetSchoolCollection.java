package com.education.management.school.application;

import com.education.management.school.domain.School;
import com.education.management.school.domain.SchoolRepository;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetSchoolCollection {
    private final SchoolRepository schoolRepository;

    public Collection<School> execute() {
        return this.schoolRepository.getAll();
    }
}
