package com.example.demo.config;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public void run(String... args) throws Exception {
        User user1 = new User(null, "Gabriel", "gabriel@gmail.com", "999999999","123456");
        User user2 = new User(null, "joão", "joão@gmail.com", "888888888", "654321");

        //userRepository.saveAll(Arrays.asList(user1, user2));
    }

}
