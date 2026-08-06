package com.cpan228.learnsphere.config;

import com.cpan228.learnsphere.model.AppUser;
import com.cpan228.learnsphere.model.Role;
import com.cpan228.learnsphere.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedDemoUsers(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            createUserIfMissing(
                    userRepository,
                    passwordEncoder,
                    "Amina",
                    "Admin",
                    "admin@learnsphere.ca",
                    "Admin123!",
                    Role.ADMIN
            );

            createUserIfMissing(
                    userRepository,
                    passwordEncoder,
                    "Ian",
                    "Instructor",
                    "instructor@learnsphere.ca",
                    "Teach123!",
                    Role.INSTRUCTOR
            );

            createUserIfMissing(
                    userRepository,
                    passwordEncoder,
                    "Sara",
                    "Student",
                    "student@learnsphere.ca",
                    "Learn123!",
                    Role.STUDENT
            );
        };
    }

    private void createUserIfMissing(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            String firstName,
            String lastName,
            String email,
            String rawPassword,
            Role role
    ) {
        if (userRepository.existsByEmailIgnoreCase(email)) {
            return;
        }

        AppUser user = new AppUser();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(
                passwordEncoder.encode(rawPassword)
        );
        user.setRole(role);
        user.setEnabled(true);

        userRepository.save(user);
    }
}