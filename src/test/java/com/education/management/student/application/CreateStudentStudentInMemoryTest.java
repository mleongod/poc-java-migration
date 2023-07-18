package com.education.management.student.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.education.management.student.application.memory.CreateStudentInMemory;
import com.education.management.student.domain.Student;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import com.education.management.student.infrastructure.mapper.StudentMapper;
import com.education.management.student.repositories.StudentInMemoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CreateStudentStudentInMemoryTest {

    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);
    @Mock
    private StudentInMemoryRepository studentInMemoryRepository;
    private CreateStudentInMemory createStudentInMemory;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        createStudentInMemory = new CreateStudentInMemory(studentInMemoryRepository);
    }

    @AfterEach
    void end() {
        Mockito.reset(studentInMemoryRepository);
    }

    @Test
    void shouldPass() {
        StudentDto studentDto = new StudentDto(
                "name", "email@test.es", 20, 5, "A");

        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        Student student = mapper.toEntity(studentDto);
        this.createStudentInMemory.execute(student);
        verify(studentInMemoryRepository, times(1)).create(studentArgumentCaptor.capture());
        assertEquals("name", studentArgumentCaptor.getValue().getName());
        assertEquals("email@test.es", studentArgumentCaptor.getValue().getEmail());
        assertEquals(5, studentArgumentCaptor.getValue().getLevel());
        assertEquals("A", studentArgumentCaptor.getValue().getSection());
        assertEquals(student.getId(), studentArgumentCaptor.getValue().getId());

    }
}
