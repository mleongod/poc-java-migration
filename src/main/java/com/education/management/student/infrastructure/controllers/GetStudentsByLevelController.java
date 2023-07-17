package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.student.application.GetStudentsByLevel;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetStudentsByLevelController {

    private final GetStudentsByLevel getStudentsByLevel;
    private final StudentMapper mapper;


    public GetStudentsByLevelController(GetStudentsByLevel getStudentsByLevel, StudentMapper mapper) {
        this.getStudentsByLevel = getStudentsByLevel;
        this.mapper = mapper;
    }

    @GetMapping(PathNames.STUDENT + "/level/{level}")
    public ResponseEntity<Collection<StudentDto>> execute(@PathVariable("level") @Valid @Positive Integer id) {
        Collection<Student> studentCollection = this.getStudentsByLevel.execute(id);
        Collection<StudentDto> studentDtoCollection = studentCollection.stream().map(this.mapper::toDto).toList();
        return ResponseEntity.ok(studentDtoCollection);
    }
}
