# LearnSphere

LearnSphere is an online learning platform developed for CPAN-228 Web Application Development — Deliverable 1.

## Group Information

**Group Name:** CodeCrafters

### Team Members

- Kirandeep Kaur
- Maheen Khan

## Project Description

LearnSphere is a web-based educational platform that helps students discover career-focused online courses. Users can browse, search, filter, sort and review available courses.

The application also allows new courses to be added through a server-validated form. All course information is stored in a persistent H2 database using Spring Data JPA.

## Deliverable 1 Features

- Responsive Home page
- About page
- How It Works page
- Course Catalogue
- Search by course title, course code or instructor
- Filter by course category
- Filter by difficulty level
- Sort by title, course code, duration, price or creation date
- Server-side pagination
- Validated Add Course form
- Course Details page
- Persistent H2 database
- Sample course records loaded through `data.sql`
- Responsive Bootstrap interface
- Custom navigation bar and footer
- Helpful form-validation messages

## Course Information

Each course contains the following information:

- Generated database ID
- Course code
- Course title
- Instructor name
- Course category
- Difficulty level
- Duration in weeks
- Price
- Course description
- Creation timestamp

## Technologies Used

- Java 21
- Spring Boot 4.0.7
- Spring MVC
- Thymeleaf
- Spring Data JPA
- H2 Database
- Jakarta Validation
- Bootstrap 5
- Maven
- HTML5
- CSS3

## Project Requirements

Before running the application, ensure the following are installed:

- JDK 21
- IntelliJ IDEA or another Java IDE
- Git
- Internet connection for downloading Maven dependencies

## How to Run the Application

1. Clone or download this repository.
2. Open the project folder in IntelliJ IDEA.
3. Allow IntelliJ to load the Maven dependencies.
4. Confirm that the project SDK is set to Java 21.
5. Open `LearnsphereApplication.java`.
6. Run the application.
7. Open the following address in a browser:

```text
http://localhost:8080
```

The application can also be started from a Windows PowerShell terminal:

```powershell
.\mvnw.cmd spring-boot:run
```

## How to Run the Tests

Stop the running application and enter:

```powershell
.\mvnw.cmd clean test
```

A successful test should finish with:

```text
BUILD SUCCESS
```

## Main Application Pages

| Page | Address |
|---|---|
| Home | `http://localhost:8080/` |
| About | `http://localhost:8080/about` |
| How It Works | `http://localhost:8080/how-it-works` |
| Course Catalogue | `http://localhost:8080/courses` |
| Add Course | `http://localhost:8080/courses/new` |

## Database

LearnSphere uses an H2 database for local development.

- `schema.sql` creates the required course table.
- `data.sql` inserts sample course records.
- Spring Data JPA manages database persistence.
- Course IDs are generated automatically.
- Each course receives a creation timestamp.
- Newly added courses remain available after the application restarts.

## Validation

The Add Course form uses server-side validation. It checks:

- Required fields
- Course-code format
- Duplicate course codes
- Duration range
- Price range
- Course category
- Difficulty level
- Minimum and maximum description length

When the submitted information is invalid, helpful validation messages are displayed beside the relevant fields.

## Searching, Filtering and Sorting

The Course Catalogue supports:

- Keyword searches using the course title, course code or instructor
- Filtering by category
- Filtering by difficulty level
- Sorting by title
- Sorting by course code
- Sorting by duration
- Sorting by price
- Sorting by creation date
- Server-side pagination

## Deliverable 1 Contributions

### Kirandeep Kaur

Kirandeep Kaur independently completed the Deliverable 1 implementation, including:

- Created and configured the Spring Boot project
- Developed the Course entity and enumerations
- Implemented server-side validation
- Configured Spring Data JPA
- Configured the persistent H2 database
- Created the database schema and sample records
- Developed the controllers and application routes
- Implemented course creation and details functionality
- Implemented searching and filtering
- Implemented sorting and server-side pagination
- Created the Thymeleaf page layouts
- Added Bootstrap styling and responsive design
- Tested navigation, forms, validation and database persistence
- Created the GitHub repository
- Prepared the project documentation

### Maheen Khan

Maheen Khan is listed as a team member. No code or documentation contribution was received from her for Deliverable 1 before the submission deadline. Responsibilities for future deliverables will be discussed, assigned and documented separately.

## Future Development

The project will be extended in future deliverables to include:

- User registration
- Secure login and logout
- Encoded passwords
- Student, instructor and administrator roles
- Protected application routes
- Role-based authorization
- Administrative course management
- A separate Spring Boot microservice
- REST API integration
- Spring profiles
- PostgreSQL and Docker support

## Course Information

**Course:** CPAN-228 Web Application Development  
**Project:** LearnSphere Online Learning Platform  
**Category:** Online Learning Platform  
**Group:** CodeCrafters