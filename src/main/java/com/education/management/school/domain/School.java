package com.education.management.school.domain;

import com.education.management.shared.domain.AggregateRoot;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;

@Getter
public class School extends AggregateRoot {
    private final String name;
    private final String address;
    private final Collection<String> students;

    public School(String name, String address, Collection<String> students) {
        super(UUID.randomUUID(), new Date(), new Date());
        this.name = name;
        this.address = address;
        this.students = students;
    }
}