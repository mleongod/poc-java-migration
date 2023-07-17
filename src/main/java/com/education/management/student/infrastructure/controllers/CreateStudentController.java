package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.student.application.CreateStudent;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStudentController {

    private final CreateStudent createStudent;

    public CreateStudentController(CreateStudent createStudent) {
        this.createStudent = createStudent;
    }

    @PostMapping(PathNames.STUDENT)
    public ResponseEntity<Student> execute(@Valid @RequestBody StudentDto dto) {
        Student student = this.createStudent.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
