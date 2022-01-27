package com.github.rod1andrade.studyspringboot.repositories;

import com.github.rod1andrade.studyspringboot.entities.Order;
import com.github.rod1andrade.studyspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository: Order
 * 
 * @author rodri
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
