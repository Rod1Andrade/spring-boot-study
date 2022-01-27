package com.github.rod1andrade.studyspringboot.configs;

import com.github.rod1andrade.studyspringboot.entities.Order;
import com.github.rod1andrade.studyspringboot.entities.User;
import com.github.rod1andrade.studyspringboot.enums.OrderStatus;
import com.github.rod1andrade.studyspringboot.repositories.OrderRepository;
import com.github.rod1andrade.studyspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) {

        // Mock Users
        User u1 = new User(null, "Rodrigo Andrade", "rodrigo@email.com", "99 9999-9999", "1234");
        User u2 = new User(null, "Gabriela Alves", "gabriela@email.com", "99 9999-9999", "1234");
        User u3 = new User(null, "Linus Torvalds", "linus@linux.com", "99 9999-9999", "1234");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        // Mock Orders
        Order o1 = new Order(null, Instant.parse("2022-01-27T10:33:00Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-01-27T10:33:00Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o3 = new Order(null, Instant.parse("2022-01-27T10:33:00Z"), OrderStatus.DELIVERED, u2);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}
