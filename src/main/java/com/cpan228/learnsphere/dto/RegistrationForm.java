package com.cpan228.learnsphere.dto;

import com.cpan228.learnsphere.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationForm {

    @NotBlank(message = "First name is required.")
    @Size(max = 50, message = "First name cannot exceed 50 characters.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(max = 50, message = "Last name cannot exceed 50 characters.")
    private String lastName;

    @NotBlank(message = "Email is required.")
    @Email(message = "Enter a valid email address.")
    @Size(max = 120, message = "Email cannot exceed 120 characters.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(
            min = 8,
            max = 72,
            message = "Password must contain between 8 and 72 characters."
    )
    private String password;

    @NotBlank(message = "Please confirm your password.")
    private String confirmPassword;

    @NotNull(message = "Select an account type.")
    private Role role;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}