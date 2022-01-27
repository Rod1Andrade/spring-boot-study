package com.github.rod1andrade.studyspringboot.configs;

import com.github.rod1andrade.studyspringboot.entities.*;
import com.github.rod1andrade.studyspringboot.enums.OrderStatus;
import com.github.rod1andrade.studyspringboot.repositories.*;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        // Mock Categories
        Category c1 = new Category(null, "Technology");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Home Appliance");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        // Mock Product
        Product p1 = new Product(null, "Lord of Rings", "some description 1", 60.0, "https://picsum.photos/200");
        Product p2 = new Product(null, "PC Gamer", "some description 2", 6000.0, "https://picsum.photos/200");
        Product p3 = new Product(null, "Google Home", "some description 3", 280.0, "https://picsum.photos/200");

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        // Associations Product and Categories
        p1.getCategories().add(c2);

        p2.getCategories().add(c1);
        p2.getCategories().add(c3);

        p3.getCategories().add(c1);
        p3.getCategories().add(c3);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        // Mock OderItems (o2)
        OrderItem oi1 = new OrderItem(p1, o1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(p3, o2, 2, p3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2));

        // Mockpayment (order o1) - Relacionamento dependente nao se chama o repository para salver
        Payment pay1 = new Payment(null, Instant.parse("2022-01-27T12:31:23Z"), o1);
        o1.setPayment(pay1);
        orderRepository.save(o1);
    }

}
