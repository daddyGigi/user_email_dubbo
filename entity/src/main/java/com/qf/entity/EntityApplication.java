package com.qf.entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
public class EntityApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntityApplication.class, args);
    }

}
