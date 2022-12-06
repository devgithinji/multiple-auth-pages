package com.densoft.multipleauthpages.config;

import com.densoft.multipleauthpages.Dao.CustomerRepository;
import com.densoft.multipleauthpages.Dao.UserRepository;
import com.densoft.multipleauthpages.model.Customer;
import com.densoft.multipleauthpages.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseLoader {
    private UserRepository userRepository;

    private CustomerRepository customerRepository;

    public DatabaseLoader(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            User user1 = new User("david@gmail.com", "password");
            User user2 = new User("john@yahoo.com", "password");

            userRepository.saveAll(List.of(user1, user2));

            Customer customer1 = new Customer("alex@gmail.com", "password", "Alex Stevenson");
            Customer customer2 = new Customer("peter@mail.ru", "password", "Peter Senkovski");

            customerRepository.saveAll(List.of(customer1, customer2));
            System.out.println("database initialized");
        };
    }
}
