package com.education.management.student.application.postgre;

import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentPostgreRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetStudentByIdInPostgre {

    private final StudentPostgreRepository studentRepository;

    public Student execute(UUID id) {
        return this.studentRepository.getById(id);

    }
}
