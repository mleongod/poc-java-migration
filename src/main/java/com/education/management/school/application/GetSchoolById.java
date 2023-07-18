package com.education.management.school.application;

import com.education.management.school.domain.School;
import com.education.management.school.domain.SchoolRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetSchoolById {
    private final SchoolRepository schoolRepository;

    public School execute(UUID uuid) {
        return this.schoolRepository.getById(uuid);
    }
}
