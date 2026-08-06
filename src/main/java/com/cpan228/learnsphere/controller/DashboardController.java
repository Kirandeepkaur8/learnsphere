package com.cpan228.learnsphere.controller;

import com.cpan228.learnsphere.model.AppUser;
import com.cpan228.learnsphere.repository.CourseRepository;
import com.cpan228.learnsphere.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public DashboardController(
            UserRepository userRepository,
            CourseRepository courseRepository
    ) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/dashboard")
    public String showDashboard(
            Authentication authentication,
            Model model
    ) {
        AppUser user = userRepository
                .findByEmailIgnoreCase(authentication.getName())
                .orElseThrow();

        model.addAttribute("user", user);
        model.addAttribute(
                "courseCount",
                courseRepository.count()
        );

        return "dashboard";
    }
}