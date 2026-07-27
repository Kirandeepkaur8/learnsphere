package com.cpan228.learnsphere.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "templates/courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course code is required.")
    @Pattern(
            regexp = "^[A-Za-z]{2,6}-\\d{3}$",
            message = "Use a course code such as WEB-101."
    )
    @Column(nullable = false, unique = true, length = 10)
    private String courseCode;

    @NotBlank(message = "Course title is required.")
    @Size(
            min = 3,
            max = 100,
            message = "Course title must contain between 3 and 100 characters."
    )
    @Column(nullable = false, length = 100)
    private String title;

    @NotBlank(message = "Instructor name is required.")
    @Size(
            min = 2,
            max = 80,
            message = "Instructor name must contain between 2 and 80 characters."
    )
    @Column(nullable = false, length = 80)
    private String instructorName;

    @NotNull(message = "Please select a category.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseCategory category;

    @NotNull(message = "Please select a difficulty level.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficultyLevel difficulty;

    @NotNull(message = "Course duration is required.")
    @Min(value = 1, message = "Duration must be at least 1 week.")
    @Max(value = 52, message = "Duration cannot exceed 52 weeks.")
    @Column(nullable = false)
    private Integer durationWeeks;

    @NotNull(message = "Course price is required.")
    @DecimalMin(value = "0.00", message = "Price cannot be negative.")
    @DecimalMax(value = "9999.99", message = "Price cannot exceed $9,999.99.")
    @Digits(
            integer = 4,
            fraction = 2,
            message = "Enter a valid price with no more than 2 decimal places."
    )
    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal price;

    @NotBlank(message = "Course description is required.")
    @Size(
            min = 20,
            max = 800,
            message = "Description must contain between 20 and 800 characters."
    )
    @Column(nullable = false, length = 800)
    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prepareForSaving() {
        if (courseCode != null) {
            courseCode = courseCode.trim().toUpperCase();
        }

        if (title != null) {
            title = title.trim();
        }

        if (instructorName != null) {
            instructorName = instructorName.trim();
        }

        if (description != null) {
            description = description.trim();
        }

        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public CourseCategory getCategory() {
        return category;
    }

    public void setCategory(CourseCategory category) {
        this.category = category;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getDurationWeeks() {
        return durationWeeks;
    }

    public void setDurationWeeks(Integer durationWeeks) {
        this.durationWeeks = durationWeeks;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}