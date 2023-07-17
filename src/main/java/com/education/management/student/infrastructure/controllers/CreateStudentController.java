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
    private final StudentMapper mapper;

    public CreateStudentController(CreateStudent createStudent, StudentMapper mapper) {
        this.createStudent = createStudent;
        this.mapper = mapper;
    }

    @PostMapping(PathNames.STUDENT)
    public ResponseEntity<StudentDto> execute(@Valid @RequestBody StudentDto dto) {
        Student student = this.mapper.toEntity(dto);
        this.createStudent.execute(student);
        StudentDto studentDto = this.mapper.toDto(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
    }
}
