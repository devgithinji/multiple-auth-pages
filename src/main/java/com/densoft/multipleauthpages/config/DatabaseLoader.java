package com.densoft.multipleauthpages.config;

import com.densoft.multipleauthpages.Dao.UserRepository;
import com.densoft.multipleauthpages.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.densoft.multipleauthpages.model.Role.ADMIN;
import static com.densoft.multipleauthpages.model.Role.USER;

@Configuration
public class DatabaseLoader {
    private UserRepository userRepository;

    public DatabaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            User user1 = new User("david@gmail.com", "password", ADMIN);
            User user2 = new User("john@yahoo.com", "password", ADMIN);
            User user3 = new User("test@gmail.com", "password", USER);
            User user4 = new User("ravi@gmail.com", "password", USER);
            userRepository.saveAll(List.of(user1, user2, user3, user4));
            System.out.println("database initialized");
        };
    }
}
