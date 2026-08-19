## Deliverable 2 — Security and User Management

Deliverable 2 adds database-backed authentication, registration and role-based authorization to LearnSphere.
LearnSphere is a secure online learning platform developed for CPAN-228 Web Application Development. The application includes Deliverable 1 — Web Front-End and Database Integration and Deliverable 2 — Security and User Management.
### Security Features

- Database-backed user registration
- BCrypt password encoding
- Custom login and logout
- Student, Instructor and Administrator roles
- Role-based navigation and dashboards
- Protected application routes
- Custom Access Denied page
- Logged-in user displayed in the navigation bar
- Instructor and Administrator course creation
- Administrator-only course editing and deletion
- Administrator user-role management
- Administrator account enable and disable controls

### Role Permissions

| Feature | Student | Instructor | Administrator |
|---|---|---|---|
| Browse courses | Yes | Yes | Yes |
| Access dashboard | Yes | Yes | Yes |
| Add courses | No | Yes | Yes |
| Edit courses | No | No | Yes |
| Delete courses | No | No | Yes |
| Access Admin area | No | No | Yes |
| Change user roles | No | No | Yes |
| Enable or disable users | No | No | Yes |

### Demo Accounts

| Role | Email | Password |
|---|---|---|
| Student | student@learnsphere.ca | Learn123! |
| Instructor | instructor@learnsphere.ca | Teach123! |
| Administrator | admin@learnsphere.ca | Admin123! |

### Main Security Routes

| Page | Route |
|---|---|
| Login | `/login` |
| Registration | `/register` |
| User Dashboard | `/dashboard` |
| Administrator Dashboard | `/admin` |
| Access Denied | `/access-denied` |

### Deliverable 2 Contribution

Kirandeep Kaur independently completed Deliverable 2, including:

- User entity and database repository
- Spring Security configuration
- BCrypt password encoding
- Registration and validation
- Student, Instructor and Administrator roles
- Custom login, logout and Access Denied pages
- Role-specific dashboards and navigation
- Administrator course management
- Administrator user-role and account-status management
- Security testing and interface improvements

## Future Development

The final project will extend LearnSphere with:

- A separate Spring Boot microservice
- A complete REST API
- HTTP Basic authentication for the microservice
- Spring development and QA profiles
- PostgreSQL integration
- Docker Compose configuration
- RestTemplate communication between applications
- A combined Administrator dashboard


Deliverable 3 — Configuration, Profiles & Database Integration

Deliverable 3 improves LearnSphere by introducing environment-specific configuration using hierarchical YAML files.

The application now supports separate development and QA environments without requiring changes to the Java source code.

YAML Configuration

The project has been migrated from traditional application.properties configuration to YAML configuration.

The main configuration files are:

src/main/resources/application.yml
src/main/resources/application-dev.yml
src/main/resources/application-qa.yml

* application.yml contains configuration shared by all environments.
* application-dev.yml contains Development/H2 settings.
* application-qa.yml contains QA/MySQL settings.

The previous application.properties file is no longer used.

⸻

Development Profile — DEV

The dev profile is used for local development and testing.

DEV Environment

* Profile: dev
* Database: H2
* Database Type: In-memory
* Server Port: 8080
* H2 Console: Enabled

The H2 database connection is:

jdbc:h2:mem:learnsphere

Because the development database is in memory, temporary data is removed when the application is stopped and restarted.

Run the DEV Profile

From the LearnSphere project directory:

.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=dev"

Open the application:

http://localhost:8080

H2 Console

While the DEV profile is running, open:

http://localhost:8080/h2-console

Use:

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:learnsphere
User Name: sa
Password: leave blank

After connecting, the application database includes tables such as:

COURSES
APP_USERS

Example query:

SELECT * FROM COURSES;

⸻

QA Profile — MySQL

The qa profile provides a persistent database environment using MySQL.

QA Environment

* Profile: qa
* Database: MySQL
* Database Name: learnsphere_qa
* Server Port: 8081
* Persistent Storage: Yes
* H2 Console: Disabled

The QA profile receives database credentials through environment variables instead of storing real credentials directly in the repository.

⸻

MySQL Database Setup

MySQL Server must be running before starting LearnSphere with the QA profile.

Create the QA database using MySQL Workbench:

CREATE DATABASE IF NOT EXISTS learnsphere_qa
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

Verify the database:

SHOW DATABASES;

The database should include:

learnsphere_qa

The application uses MySQL-specific initialization files:

src/main/resources/schema-mysql.sql
src/main/resources/data-mysql.sql

The DEV/H2 profile uses:

src/main/resources/schema-h2.sql
src/main/resources/data-h2.sql

⸻

QA Environment Variables

Before starting the QA profile in Windows PowerShell, configure the following variables:

$env:DB_USERNAME="root"
$env:DB_PASSWORD="YOUR_MYSQL_PASSWORD"
$env:DB_URL="jdbc:mysql://localhost:3306/learnsphere_qa"

Replace:

YOUR_MYSQL_PASSWORD

with the password configured on your local MySQL server.

Do not commit a real MySQL password to GitHub.

⸻

Run the QA Profile

After configuring the required environment variables:

.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=qa"

Open LearnSphere at:

http://localhost:8081

The same LearnSphere application runs using MySQL instead of H2 without requiring Java source-code changes.

⸻

Verify MySQL Integration

In MySQL Workbench:

USE learnsphere_qa;
SHOW TABLES;

Expected application tables include:

app_users
courses

Course records can be checked with:

SELECT course_code, title
FROM courses;

⸻

Database Persistence

The two profiles demonstrate different database behaviours.

DEV / H2

The development database is in memory.

Temporary records do not remain after the application is completely restarted.

QA / MySQL

The QA database is persistent.

Records created while running the QA profile remain available after the Spring Boot application is restarted.

This demonstrates profile-based database switching without modifying application source code.

⸻

Profile Summary

Profile	Database	Storage	Port	H2 Console
dev	H2	In-memory	8080	Enabled
qa	MySQL	Persistent	8081	Disabled

⸻

Build and Test

To clean and test the LearnSphere project:

.\mvnw.cmd clean test

A successful build should end with:

BUILD SUCCESS

⸻

Deliverable 3 Contributions

Kirandeep Kaur

Deliverable 3 work included:

* Migrated application configuration from .properties to YAML.
* Added common application.yml configuration.
* Configured the dev profile.
* Integrated the H2 in-memory development database.
* Configured and tested the H2 Console.
* Added development-specific H2 security configuration.
* Configured the qa profile.
* Integrated the persistent MySQL QA database.
* Added environment-variable based database credentials.
* Added profile-specific H2 and MySQL schema files.
* Added profile-specific H2 and MySQL data files.
* Tested DEV/H2 profile execution.
* Tested QA/MySQL profile execution.
* Verified switching between profiles without Java source-code modifications.
* Verified MySQL persistence.
* Performed final application integration and build testing.

Additional team-member contributions should be documented here only when their completed work is included in the final repository.