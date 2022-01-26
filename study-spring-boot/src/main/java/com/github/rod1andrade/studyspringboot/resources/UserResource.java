package com.github.rod1andrade.studyspringboot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.rod1andrade.studyspringboot.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping()
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Rodrigo Andrade", "rodrigo@gmail.com", "1", "1");
		return ResponseEntity.ok().body(user);
	}
}
