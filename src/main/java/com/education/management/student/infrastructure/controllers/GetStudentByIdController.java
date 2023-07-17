package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.student.application.GetStudentById;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class GetStudentByIdController {

    private final GetStudentById getStudentById;

    private final StudentMapper mapper;

    public GetStudentByIdController(GetStudentById getStudentById, StudentMapper mapper) {
        this.getStudentById = getStudentById;
        this.mapper = mapper;
    }

    @GetMapping(PathNames.STUDENT + "/{id}")
    public ResponseEntity<StudentDto> execute(@PathVariable("id") @Valid @Size(min = 36) String id) {
        Student student = this.getStudentById.execute(UUID.fromString(id));
        StudentDto studentDto = this.mapper.toDto(student);
        return ResponseEntity.ok(studentDto);
    }
}
