package com.github.rod1andrade.studyspringboot.repositories;

import com.github.rod1andrade.studyspringboot.entities.OrderItem;
import com.github.rod1andrade.studyspringboot.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
