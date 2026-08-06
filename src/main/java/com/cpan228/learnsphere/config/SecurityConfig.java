package com.cpan228.learnsphere.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http.authorizeHttpRequests(authorize -> authorize

                // Administrator-only area
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")

                // Only Admin can edit or delete courses
                .requestMatchers(
                        HttpMethod.GET,
                        "/courses/*/edit"
                )
                .hasRole("ADMIN")

                .requestMatchers(
                        HttpMethod.POST,
                        "/courses/*/edit",
                        "/courses/*/delete"
                )
                .hasRole("ADMIN")

                // Instructor and Admin can add courses
                .requestMatchers(
                        HttpMethod.GET,
                        "/courses/new"
                )
                .hasAnyRole("INSTRUCTOR", "ADMIN")

                .requestMatchers(
                        HttpMethod.POST,
                        "/courses"
                )
                .hasAnyRole("INSTRUCTOR", "ADMIN")

                // Public pages
                .requestMatchers(
                        "/",
                        "/home",
                        "/about",
                        "/how-it-works",
                        "/register",
                        "/login",
                        "/access-denied",
                        "/error",
                        "/css/**",
                        "/favicon.ico"
                )
                .permitAll()

                // Public course list and details
                .requestMatchers(
                        HttpMethod.GET,
                        "/courses",
                        "/courses/*"
                )
                .permitAll()

                // Everything else needs login
                .anyRequest()
                .authenticated()
        );

        http.formLogin(form -> form
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
        );

        http.logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
        );

        http.exceptionHandling(exception -> exception
                .accessDeniedPage("/access-denied")
        );

        return http.build();
    }
}