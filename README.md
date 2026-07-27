# LearnSphere

LearnSphere is an online learning platform created for CPAN-228
Web Application Development Deliverable 1.

## Developer

## Group

**Group Name:** CodeCrafters

## Team Members and Contributions

### Kirandeep Kaur

- Created the Spring Boot project structure
- Developed the Course entity and validation
- Configured Spring Data JPA and H2 persistence
- Implemented course controllers and routing
- Implemented searching, filtering, sorting and pagination
- Created database initialization scripts

### Maheen Khan

- Improved the Thymeleaf page layouts
- Worked on Bootstrap and responsive styling
- Reviewed the Course form and validation presentation
- Tested navigation, filtering, sorting and responsiveness
- Assisted with project documentation and final quality checks

## Project Description

LearnSphere helps students discover career-focused online courses.
Users can search, filter, sort and review courses. Instructors can
add new courses through a validated form, and course information is
saved in a persistent H2 database.

## Features

- Responsive Home page
- About page
- How It Works page
- Course Catalogue
- Search by title, code or instructor
- Filter by category
- Filter by difficulty
- Sort by title, code, duration, price or date
- Server-side pagination
- Validated Add Course form
- Course Details page
- H2 database persistence
- Sample records loaded through data.sql
- Bootstrap styling

## Technologies

- Java 21
- Spring Boot 4.0.7
- Spring MVC
- Thymeleaf
- Spring Data JPA
- H2 Database
- Jakarta Validation
- Bootstrap 5
- Maven

## How to Run

1. Install JDK 21.
2. Open the project in IntelliJ IDEA.
3. Load the Maven project.
4. Run LearnsphereApplication.java.
5. Open http://localhost:8080.

The application can also be started on Windows with:

.\mvnw.cmd spring-boot:run

## Main Pages

- `/` — Home
- `/about` — About
- `/how-it-works` — How It Works
- `/courses` — Course Catalogue
- `/courses/new` — Add Course

## Deliverable 1 Contributions

### Kirandeep Kaur

Kirandeep Kaur created the Spring Boot project structure and worked on the Course domain model, validation, Spring Data JPA persistence, H2 database initialization, controllers, routing, searching, filtering, sorting and server-side pagination.

### Maheen Khan

Maheen Khan worked on the Thymeleaf page layouts, Bootstrap styling, responsive design, interface review, form-validation testing, feature testing and project documentation.