package com.education.management.student.application.memory;

import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentInMemoryRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetStudentByIdInMemory {

    private final StudentInMemoryRepository studentInMemoryRepository;


    public Student execute(UUID id) {
        return this.studentInMemoryRepository.getById(id);

    }
}
