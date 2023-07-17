package com.education.management.student.application;

import com.education.management.student.domain.Student;
import com.education.management.student.domain.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetStudentById {

    private final StudentRepository studentRepository;

    public GetStudentById(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(UUID id) {
        return this.studentRepository.getById(id);

    }
}
