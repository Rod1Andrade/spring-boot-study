package com.github.rod1andrade.studyspringboot.services;

import com.github.rod1andrade.studyspringboot.entities.Product;
import com.github.rod1andrade.studyspringboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> optionalProduct = repository.findById(id);
		return optionalProduct.orElse(null);
	}
	
}
