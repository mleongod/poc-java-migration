package com.education.management.student.application.mongo;

import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentMongoRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetStudentByIdInMongo {

    private final StudentMongoRepository studentRepository;

    public Student execute(UUID id) {
        return this.studentRepository.getById(id);

    }
}
