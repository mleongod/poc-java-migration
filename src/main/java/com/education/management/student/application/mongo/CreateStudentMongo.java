package com.education.management.student.application.mongo;

import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentMongoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateStudentMongo {

    private final StudentMongoRepository studentRepository;

    public void execute(Student student) {
        this.studentRepository.create(student);
    }
}
