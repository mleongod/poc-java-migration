package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.student.application.GetStudentById;
import com.education.management.student.domain.Student;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Validated
public class GetStudentByIdController {

    private final GetStudentById getStudentById;

    public GetStudentByIdController(GetStudentById getStudentById) {
        this.getStudentById = getStudentById;
    }

    @GetMapping(PathNames.STUDENT + "/{id}")
    public ResponseEntity<Student> execute(@PathVariable("id") @Valid @Size(min = 36) String id) {
        Student student = this.getStudentById.execute(UUID.fromString(id));
        return ResponseEntity.ok(student);
    }
}
