package com.github.rod1andrade.studyspringboot.repositories;

import com.github.rod1andrade.studyspringboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository: Category
 * 
 * @author rodri
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
