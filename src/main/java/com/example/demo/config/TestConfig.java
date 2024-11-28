package com.example.demo.config;

import com.example.demo.entities.Order;
import com.example.demo.entities.User;
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

    public void run(String... args) throws Exception {
        User user1 = new User(null, "Gabriel", "gabriel@gmail.com", "999999999","123456");
        User user2 = new User(null, "joão", "joão@gmail.com", "888888888", "654321");

        Order order1 = new Order(null, Instant.parse("2024-11-28T14:57:12Z"), user1);
        Order order2 = new Order(null, Instant.parse("2024-07-12T20:32:58Z"), user2);
        Order order3 = new Order(null, Instant.parse("2024-04-10T05:57:32Z"), user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }

}
