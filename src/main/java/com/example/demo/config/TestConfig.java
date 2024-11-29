package com.example.demo.config;

import com.example.demo.entities.Category;
import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.entities.enums.OrderStatus;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    public void run(String... args) throws Exception {
        User user1 = new User(null, "Gabriel", "gabriel@gmail.com", "999999999","123456");
        User user2 = new User(null, "joão", "joão@gmail.com", "888888888", "654321");

        Order order1 = new Order(null, Instant.parse("2024-11-28T14:57:12Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2024-07-12T20:32:58Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2024-04-10T05:57:32Z"), OrderStatus.WAITING_PAYMENT, user1);

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
    }

}
