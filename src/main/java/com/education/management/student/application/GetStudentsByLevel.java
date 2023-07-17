package com.education.management.student.application;

import com.education.management.student.domain.Student;
import com.education.management.student.domain.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GetStudentsByLevel {

    private final StudentRepository studentRepository;

    public GetStudentsByLevel(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> execute(Integer level) {
        return this.studentRepository.getByLevel(level);

    }
}
