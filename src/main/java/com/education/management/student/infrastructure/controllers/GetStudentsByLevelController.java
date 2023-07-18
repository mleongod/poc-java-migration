package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.student.application.memory.GetStudentsByLevelInMemory;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import com.education.management.student.infrastructure.mapper.StudentMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class GetStudentsByLevelController {

    private final GetStudentsByLevelInMemory getStudentsByLevelInMemory;
    private final StudentMapper mapper;

    @GetMapping(PathNames.STUDENT + "/level/{level}")
    public ResponseEntity<Collection<StudentDto>> execute(@PathVariable("level") @Valid @Positive Integer id) {
        Collection<Student> studentCollection = this.getStudentsByLevelInMemory.execute(id);
        Collection<StudentDto> studentDtoCollection = studentCollection.stream().map(this.mapper::toDto).toList();
        return ResponseEntity.ok(studentDtoCollection);
    }
}
