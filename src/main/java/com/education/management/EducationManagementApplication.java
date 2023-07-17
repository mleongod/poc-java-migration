package com.education.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.education")
public class EducationManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationManagementApplication.class, args);
    }

}
