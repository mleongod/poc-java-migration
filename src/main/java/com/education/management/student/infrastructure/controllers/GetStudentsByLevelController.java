package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.student.application.GetStudentsByLevel;
import com.education.management.student.domain.Student;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GetStudentsByLevelController {

    private final GetStudentsByLevel getStudentsByLevel;

    public GetStudentsByLevelController(GetStudentsByLevel getStudentsByLevel) {
        this.getStudentsByLevel = getStudentsByLevel;
    }

    @GetMapping(PathNames.STUDENT + "/level/{level}")
    public Collection<Student> execute(@PathVariable("level") @Valid @Positive Integer id) {
        Collection<Student> studentCollection = this.getStudentsByLevel.execute(id);
        return studentCollection;
    }
}
