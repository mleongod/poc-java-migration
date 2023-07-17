package com.education.management.student.domain;

import com.education.management.shared.domain.Person;
import com.education.management.shared.domain.PersonRoles;
import lombok.Getter;

@Getter
public class Student extends Person {

    private final Integer level;
    private final String section;

    public Student(String name, String email, Integer age, Integer level, String section) {
        super(name, email, age, PersonRoles.STUDENT);
        this.level = level;
        this.section = section;
    }
}
