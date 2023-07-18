package com.education.management.student.infrastructure.persistence.mongo;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "students")
public class StudentMongoModel {
  private UUID id;
  private String name;
  private String email;
  private String role;
  private Integer age;
  private Integer level;
  private String section;
}
