package com.education.management.student.infrastructure.persistence.postgre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "student")
public class StudentPostgreModel {

  @Id
  private UUID id;

  @Size(max = 255)
  @NotNull
  @Column
  private String name;

  @Size(max = 255)
  @NotNull
  @Column
  private String email;

  @Size(max = 50)
  @NotNull
  @Column
  private String role;

  @Column
  private Integer age;

  @Column
  private Integer level;

  @Size(max = 50)
  @NotNull
  @Column
  private String section;
}
