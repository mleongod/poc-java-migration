package com.education.management.shared.domain;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public abstract class Person extends AggregateRoot {
    protected String name;
    protected String email;
    protected Integer age;
    protected PersonRoles role;

    public Person(String name, String email, Integer age, PersonRoles role) {
        super(UUID.randomUUID(), new Date(), new Date());
        this.name = name;
        this.email = email;
        this.age = age;
        this.role = role;
    }
}
