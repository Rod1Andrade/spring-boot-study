package com.github.rod1andrade.studyspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudySpringBootApplication {

	@GetMapping(path = "hello", name = "hello")
	public String hello() {
		return "Hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(StudySpringBootApplication.class, args);
	}

}
