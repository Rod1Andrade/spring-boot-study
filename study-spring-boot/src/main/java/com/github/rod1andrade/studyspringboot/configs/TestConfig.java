package com.github.rod1andrade.studyspringboot.configs;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.rod1andrade.studyspringboot.entities.User;
import com.github.rod1andrade.studyspringboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		List<User> users = Arrays.asList(
			new User(null, "Rodrigo Andrade", "rodrigo@email.com", "99 9999-9999", "1234"),
			new User(null, "Gabriela Alves", "gabriela@email.com", "99 9999-9999", "1234"),
			new User(null, "Linus Torvalds", "linus@linux.com", "99 9999-9999", "1234")
		);
		
		userRepository.saveAll(users);
	}

}
