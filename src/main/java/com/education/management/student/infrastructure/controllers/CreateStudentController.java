package com.education.management.student.infrastructure.controllers;

import com.education.management.shared.infrastructure.helpers.PathNames;
import com.education.management.shared.infrastructure.kafka.KafkaProducer;
import com.education.management.student.application.memory.CreateStudentInMemory;
import com.education.management.student.application.mongo.CreateStudentMongo;
import com.education.management.student.application.postgre.CreateStudentPostgre;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import com.education.management.student.infrastructure.mapper.StudentMapper;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class CreateStudentController {

  private final CreateStudentInMemory createStudentInMemory;
  private final CreateStudentMongo createStudentMongo;
  private final CreateStudentPostgre createStudentPostgre;
  private final StudentMapper mapper;
  private final KafkaProducer kafkaProducer;

  @PostMapping(PathNames.STUDENT)
  public ResponseEntity<StudentDto> execute(
      @RequestHeader(value = "source", required = false) Optional<String> source,
      @Valid @RequestBody StudentDto dto) {

    Student student = this.mapper.toEntity(dto);
    switch (source.orElse("")) {
      case "mongo" -> this.createStudentMongo.execute(student);
      case "postgre" -> this.createStudentPostgre.execute(student);
      default -> this.createStudentInMemory.execute(student);
    }
    StudentDto studentDto = this.mapper.toDto(student);
    this.kafkaProducer.sendMessage("student-" + student.getId());
    return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
  }
}
