package com.hr.learning.projectbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication is composed of following annotations:
 * 	@EnableAutoConfiguration    - Spring Boot will automatically configure your project based on dependencies.
 *	@ComponentScan				- Enables the Spring Boot component scan to find all components from your application.
 *  @Configure					- Defines the class that can be used as a source of bean definitions.
 */
@SpringBootApplication
public class ProjectbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectbackendApplication.class, args);
    }
}
