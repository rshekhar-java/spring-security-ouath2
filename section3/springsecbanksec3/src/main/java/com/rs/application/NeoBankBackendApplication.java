package com.rs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.rs.controllers", "com.rs.config"})
//@ComponentScans({ @ComponentScan("com.rs.controllers"), @ComponentScan("com.rs.config")})
@EnableJpaRepositories("com.rs.repositories")
@EntityScan("com.rs.model")
public class NeoBankBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeoBankBackendApplication.class, args);
    }

}
