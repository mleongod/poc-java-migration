package com.education.management.school.infrastructure.persistence;

import com.education.management.school.domain.School;
import com.education.management.school.domain.SchoolRepository;
import com.education.management.shared.infrastructure.persistence.inmemory.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolRepositoryImplementation extends CrudRepository<School> implements SchoolRepository {
    public SchoolRepositoryImplementation() {
        super(School.class.getSimpleName());
    }
}
