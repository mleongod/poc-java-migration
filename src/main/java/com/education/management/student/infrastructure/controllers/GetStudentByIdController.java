package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.student.application.memory.GetStudentByIdInMemory;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import com.education.management.student.infrastructure.mapper.StudentMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class GetStudentByIdController {

    private final GetStudentByIdInMemory getStudentByIdInMemory;

    private final StudentMapper mapper;

    @GetMapping(PathNames.STUDENT + "/{id}")
    public ResponseEntity<StudentDto> execute(@PathVariable("id") @Valid @Size(min = 36) String id) {
        Student student = this.getStudentByIdInMemory.execute(UUID.fromString(id));
        StudentDto studentDto = this.mapper.toDto(student);
        return ResponseEntity.ok(studentDto);
    }
}
