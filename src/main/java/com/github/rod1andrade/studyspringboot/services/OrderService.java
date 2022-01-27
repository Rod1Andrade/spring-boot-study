package com.github.rod1andrade.studyspringboot.services;

import com.github.rod1andrade.studyspringboot.entities.Order;
import com.github.rod1andrade.studyspringboot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> optionalOrder = repository.findById(id);
		return optionalOrder.orElse(null);
	}
	
}
