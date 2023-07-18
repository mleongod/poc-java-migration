package com.education.management.student.application.postgre;

import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentPostgreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateStudentPostgre {

    private final StudentPostgreRepository studentRepository;

    public void execute(Student student) {
        this.studentRepository.create(student);
    }
}
