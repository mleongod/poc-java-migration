package com.education.management.student.application;

import com.education.management.student.domain.Student;
import com.education.management.student.domain.StudentRepository;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class CreateStudent {

    private final StudentRepository studentRepository;

    public CreateStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(StudentDto dto) {

        Student student = new Student(dto.getName(), dto.getEmail(), dto.getAge(), dto.getLevel(), dto.getSection());
        this.studentRepository.create(student);

        return student;
    }
}
