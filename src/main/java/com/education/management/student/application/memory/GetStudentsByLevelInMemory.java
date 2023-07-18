package com.education.management.student.application.memory;

import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentInMemoryRepository;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetStudentsByLevelInMemory {

    private final StudentInMemoryRepository studentInMemoryRepository;


    public Collection<Student> execute(Integer level) {
        return this.studentInMemoryRepository.getByLevel(level);

    }
}
