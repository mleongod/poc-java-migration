package com.education.management.student.application.postgre;

import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentPostgreRepository;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetStudentsByLevelPostgre {

    private final StudentPostgreRepository studentRepository;


    public Collection<Student> execute(Integer level) {
        return this.studentRepository.getByLevel(level);

    }
}
