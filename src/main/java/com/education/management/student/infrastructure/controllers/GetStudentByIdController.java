package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.student.application.memory.GetStudentByIdInMemory;
import com.education.management.student.application.mongo.GetStudentByIdInMongo;
import com.education.management.student.application.postgre.GetStudentByIdInPostgre;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import com.education.management.student.infrastructure.mapper.StudentMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class GetStudentByIdController {

    private final GetStudentByIdInMemory getStudentByIdInMemory;
    private final GetStudentByIdInMongo getStudentByIdInMongo;
    private final GetStudentByIdInPostgre getStudentByIdInPostgre;

    private final StudentMapper mapper;

    @GetMapping(PathNames.STUDENT + "/{id}")
    public ResponseEntity<StudentDto> execute(@PathVariable("id") @Valid @Size(min = 36) String id,
        @RequestHeader(value = "source", required = false) Optional<String> source) {
        UUID uuid = UUID.fromString(id);
        Student student;
        switch (source.orElse("")) {
            case "mongo" -> student = this.getStudentByIdInMongo.execute(uuid);
            case "postgre" -> student = this.getStudentByIdInPostgre.execute(uuid);
            default -> student = this.getStudentByIdInMemory.execute(uuid);
        }
        StudentDto studentDto = this.mapper.toDto(student);
        return ResponseEntity.ok(studentDto);
    }
}
