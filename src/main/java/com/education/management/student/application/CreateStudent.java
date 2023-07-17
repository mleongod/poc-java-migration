package com.education.management.student.application;

import com.education.management.student.domain.Student;
import com.education.management.student.domain.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateStudent {

    private final StudentRepository studentRepository;

    public CreateStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void execute(Student student) {
        this.studentRepository.create(student);
    }
}
