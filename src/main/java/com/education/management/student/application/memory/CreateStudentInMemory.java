package com.education.management.student.application.memory;

import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentInMemoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateStudentInMemory {

    private final StudentInMemoryRepository studentInMemoryRepository;

    public void execute(Student student) {
        this.studentInMemoryRepository.create(student);
    }
}
