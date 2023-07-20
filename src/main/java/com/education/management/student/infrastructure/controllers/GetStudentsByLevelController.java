package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.student.application.memory.GetStudentsByLevelInMemory;
import com.education.management.student.application.mongo.GetStudentsByLevelMongo;
import com.education.management.student.application.postgre.GetStudentsByLevelPostgre;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import com.education.management.student.infrastructure.mapper.StudentMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.Collection;
import java.util.Optional;
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
public class GetStudentsByLevelController {

    private final GetStudentsByLevelInMemory getStudentsByLevelInMemory;
    private final GetStudentsByLevelMongo getStudentsByLevelMongo;
    private final GetStudentsByLevelPostgre getStudentsByLevelPostgre;
    private final StudentMapper mapper;

    @GetMapping(PathNames.STUDENT + "/level/{level}")
    public ResponseEntity<Collection<StudentDto>> execute(
        @PathVariable("level") @Valid @Positive Integer level,
        @RequestHeader(value = "source", required = false) Optional<String> source
    ) {
        Collection<Student> studentCollection;
      switch (source.orElse("")) {
            case "mongo" -> studentCollection = this.getStudentsByLevelMongo.execute(level);
            case "postgre" -> studentCollection = this.getStudentsByLevelPostgre.execute(level);
            default -> studentCollection = this.getStudentsByLevelInMemory.execute(level);
        }
        Collection<StudentDto> studentDtoCollection = studentCollection.stream().map(this.mapper::toDto).toList();
        return ResponseEntity.ok(studentDtoCollection);
    }
}
