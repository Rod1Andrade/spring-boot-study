package com.github.rod1andrade.studyspringboot.services;

import com.github.rod1andrade.studyspringboot.entities.Category;
import com.github.rod1andrade.studyspringboot.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = repository.findById(id);
		return optionalCategory.orElse(null);
	}
	
}
