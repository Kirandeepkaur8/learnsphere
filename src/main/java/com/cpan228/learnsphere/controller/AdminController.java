package com.cpan228.learnsphere.controller;

import com.cpan228.learnsphere.model.AppUser;
import com.cpan228.learnsphere.model.Role;
import com.cpan228.learnsphere.repository.CourseRepository;
import com.cpan228.learnsphere.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public AdminController(
            CourseRepository courseRepository,
            UserRepository userRepository
    ) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("roles")
    public Role[] getRoles() {
        return Role.values();
    }

    @GetMapping
    public String showAdminDashboard(
            Model model,
            Authentication authentication
    ) {
        model.addAttribute(
                "courses",
                courseRepository.findAll(
                        Sort.by("title").ascending()
                )
        );

        model.addAttribute(
                "users",
                userRepository.findAll(
                        Sort.by("email").ascending()
                )
        );

        model.addAttribute(
                "courseCount",
                courseRepository.count()
        );

        model.addAttribute(
                "userCount",
                userRepository.count()
        );

        model.addAttribute(
                "currentAdminEmail",
                authentication.getName()
        );

        return "admin/dashboard";
    }

    @PostMapping("/users/{id}/role")
    public String updateUserRole(
            @PathVariable Long id,
            @RequestParam Role role,
            Authentication authentication,
            RedirectAttributes redirectAttributes
    ) {
        AppUser user = findUser(id);

        if (user.getEmail().equalsIgnoreCase(
                authentication.getName()
        )) {
            redirectAttributes.addFlashAttribute(
                    "adminError",
                    "For safety, you cannot change your own administrator role."
            );

            return "redirect:/admin";
        }

        user.setRole(role);
        userRepository.save(user);

        redirectAttributes.addFlashAttribute(
                "adminSuccess",
                "User role updated successfully."
        );

        return "redirect:/admin";
    }

    @PostMapping("/users/{id}/toggle")
    public String toggleUserStatus(
            @PathVariable Long id,
            Authentication authentication,
            RedirectAttributes redirectAttributes
    ) {
        AppUser user = findUser(id);

        if (user.getEmail().equalsIgnoreCase(
                authentication.getName()
        )) {
            redirectAttributes.addFlashAttribute(
                    "adminError",
                    "For safety, you cannot disable your own account."
            );

            return "redirect:/admin";
        }

        user.setEnabled(!user.isEnabled());
        userRepository.save(user);

        redirectAttributes.addFlashAttribute(
                "adminSuccess",
                "User account status updated."
        );

        return "redirect:/admin";
    }

    private AppUser findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User not found"
                        )
                );
    }
}