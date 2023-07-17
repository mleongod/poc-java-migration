package com.education.management.student.application;

import com.education.management.student.domain.Student;
import com.education.management.student.domain.StudentRepository;
import com.education.management.student.infrastructure.controllers.dto.StudentDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateStudentStudentTest {

    @Mock
    private StudentRepository studentRepository;
    private CreateStudent createStudent;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        createStudent = new CreateStudent(studentRepository);
    }

    @AfterEach
    void end() {
        Mockito.reset(studentRepository);
    }

    @Test
    void shouldPass() {
        StudentDto studentDto = new StudentDto(
                "name", "email@test.es", 20, 5, "A");

        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        Student student = this.createStudent.execute(studentDto);
        verify(studentRepository, times(1)).create(studentArgumentCaptor.capture());
        assertEquals("name", studentArgumentCaptor.getValue().getName());
        assertEquals("email@test.es", studentArgumentCaptor.getValue().getEmail());
        assertEquals(5, studentArgumentCaptor.getValue().getLevel());
        assertEquals("A", studentArgumentCaptor.getValue().getSection());
        assertEquals(student.getId(), studentArgumentCaptor.getValue().getId());

    }
}