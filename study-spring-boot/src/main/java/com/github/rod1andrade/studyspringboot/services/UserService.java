package com.github.rod1andrade.studyspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.rod1andrade.studyspringboot.entities.User;
import com.github.rod1andrade.studyspringboot.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = repository.findById(id);
		return optionalUser.get();
	}
	
}
