package com.cpan228.learnsphere.controller;

import com.cpan228.learnsphere.dto.RegistrationForm;
import com.cpan228.learnsphere.model.AppUser;
import com.cpan228.learnsphere.model.Role;
import com.cpan228.learnsphere.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("registrationRoles")
    public Role[] registrationRoles() {
        return new Role[]{
                Role.STUDENT,
                Role.INSTRUCTOR
        };
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {

        if (!model.containsAttribute("registrationForm")) {
            model.addAttribute(
                    "registrationForm",
                    new RegistrationForm()
            );
        }

        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid
            @ModelAttribute("registrationForm")
            RegistrationForm registrationForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        String normalizedEmail =
                registrationForm.getEmail() == null
                        ? ""
                        : registrationForm.getEmail()
                        .trim()
                        .toLowerCase();

        if (!normalizedEmail.isBlank()
                && userRepository.existsByEmailIgnoreCase(
                normalizedEmail
        )) {

            bindingResult.rejectValue(
                    "email",
                    "duplicate",
                    "An account with this email already exists."
            );
        }

        if (registrationForm.getPassword() != null
                && !registrationForm.getPassword().equals(
                registrationForm.getConfirmPassword()
        )) {

            bindingResult.rejectValue(
                    "confirmPassword",
                    "mismatch",
                    "The passwords do not match."
            );
        }

        if (registrationForm.getRole() == Role.ADMIN) {

            bindingResult.rejectValue(
                    "role",
                    "invalid",
                    "Administrator accounts cannot be self-registered."
            );
        }

        if (bindingResult.hasErrors()) {
            return "auth/register";
        }

        AppUser user = new AppUser();
        user.setFirstName(registrationForm.getFirstName());
        user.setLastName(registrationForm.getLastName());
        user.setEmail(normalizedEmail);

        user.setPassword(
                passwordEncoder.encode(
                        registrationForm.getPassword()
                )
        );

        user.setRole(registrationForm.getRole());
        user.setEnabled(true);

        userRepository.save(user);

        redirectAttributes.addFlashAttribute(
                "registrationMessage",
                "Your account was created. Sign in with your email and password."
        );

        return "redirect:/login?registered";
    }
}