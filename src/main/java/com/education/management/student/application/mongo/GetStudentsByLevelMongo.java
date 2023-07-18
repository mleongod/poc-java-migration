package com.education.management.student.application.mongo;

import com.education.management.student.domain.Student;
import com.education.management.student.repositories.StudentMongoRepository;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetStudentsByLevelMongo {

    private final StudentMongoRepository studentRepository;


    public Collection<Student> execute(Integer level) {
        return this.studentRepository.getByLevel(level);

    }
}
