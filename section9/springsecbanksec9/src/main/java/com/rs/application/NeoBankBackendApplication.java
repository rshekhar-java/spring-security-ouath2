package com.rs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(scanBasePackages={"com.rs.controllers", "com.rs.config"})
//@ComponentScans({ @ComponentScan("com.rs.controllers"), @ComponentScan("com.rs.config")})
@EnableJpaRepositories("com.rs.repositories")
@EntityScan("com.rs.model")
@EnableWebSecurity(debug = true)
public class NeoBankBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeoBankBackendApplication.class, args);
    }

}
