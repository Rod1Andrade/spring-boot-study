package com.github.rod1andrade.studyspringboot.repositories;

import com.github.rod1andrade.studyspringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
