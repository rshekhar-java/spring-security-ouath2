package com.rs.springsecbanksec2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({ @ComponentScan("com.rs.controllers"), @ComponentScan("com.rs.config") })
public class Springsecbanksec2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springsecbanksec2Application.class, args);
    }

}
