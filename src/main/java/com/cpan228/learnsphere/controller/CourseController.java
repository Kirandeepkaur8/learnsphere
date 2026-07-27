package com.cpan228.learnsphere.controller;

import com.cpan228.learnsphere.model.Course;
import com.cpan228.learnsphere.model.CourseCategory;
import com.cpan228.learnsphere.model.DifficultyLevel;
import com.cpan228.learnsphere.repository.CourseRepository;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final Set<String> ALLOWED_SORT_FIELDS =
            Set.of(
                    "title",
                    "courseCode",
                    "durationWeeks",
                    "price",
                    "createdAt"
            );

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @ModelAttribute("categories")
    public CourseCategory[] getCategories() {
        return CourseCategory.values();
    }

    @ModelAttribute("difficultyLevels")
    public DifficultyLevel[] getDifficultyLevels() {
        return DifficultyLevel.values();
    }

    @GetMapping
    public String showCourses(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(required = false) CourseCategory category,
            @RequestParam(required = false) DifficultyLevel difficulty,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "0") int page,
            Model model
    ) {
        String safeSortField =
                ALLOWED_SORT_FIELDS.contains(sortBy)
                        ? sortBy
                        : "title";

        Sort.Direction safeDirection =
                direction.equalsIgnoreCase("desc")
                        ? Sort.Direction.DESC
                        : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                Math.max(page, 0),
                6,
                Sort.by(safeDirection, safeSortField)
        );

        Page<Course> coursePage =
                courseRepository.searchCourses(
                        keyword.trim(),
                        category,
                        difficulty,
                        pageable
                );

        model.addAttribute("coursePage", coursePage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedDifficulty", difficulty);
        model.addAttribute("sortBy", safeSortField);
        model.addAttribute(
                "direction",
                safeDirection.name().toLowerCase()
        );

        return "courses/list";
    }

    @GetMapping("/new")
    public String showCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/form";
    }

    @PostMapping
    public String saveCourse(
            @Valid @ModelAttribute("course") Course course,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (StringUtils.hasText(course.getCourseCode())
                && courseRepository.existsByCourseCodeIgnoreCase(
                course.getCourseCode().trim()
        )) {

            bindingResult.rejectValue(
                    "courseCode",
                    "duplicate",
                    "A course with this code already exists."
            );
        }

        if (bindingResult.hasErrors()) {
            return "courses/form";
        }

        Course savedCourse = courseRepository.save(course);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Course was added successfully."
        );

        return "redirect:/courses/" + savedCourse.getId();
    }

    @GetMapping("/{id}")
    public String showCourseDetails(
            @PathVariable Long id,
            Model model
    ) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found"
                ));

        model.addAttribute("course", course);

        return "courses/details";
    }
}