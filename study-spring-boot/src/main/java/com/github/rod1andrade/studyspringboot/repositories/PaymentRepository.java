package com.github.rod1andrade.studyspringboot.repositories;

import com.github.rod1andrade.studyspringboot.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
