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


## Deliverable 3 — QA / MySQL Testing  - Maheen 

### QA / MySQL Profile

The QA environment was configured to use a separate MySQL database for testing and persistence verification.

The QA database is:

`learnsphere_qa`

The database was created using:

```sql
CREATE DATABASE learnsphere_qa;


The QA Spring profile is stored in:

src/main/resources/application-qa.properties


The QA profile uses the following MySQL configuration:

spring.application.name=LearnSphere


spring.datasource.url=jdbc:mysql://localhost:3306/learnsphere_qa
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=${MYSQL_USERNAME:root}
spring.datasource.password=${MYSQL_PASSWORD:}


spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=false
spring.jpa.open-in-view=false


spring.sql.init.mode=never


spring.h2.console.enabled=false


MySQL Dependency

MySQL Connector/J was added to pom.xml so that the Spring Boot application can connect to the MySQL QA database.

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>

Running the QA Profile

The QA profile can be started using:

mvn spring-boot:run -Dspring-boot.run.profiles=qa

The application log was verified to show:

The following 1 profile is active: "qa"

The application was also verified to successfully connect to:

jdbc:mysql://localhost:3306/learnsphere_qa

The MySQL connection was confirmed through the Spring Boot startup logs, which showed MySQL Connector/J being used successfully.

MySQL Persistence Verification

The QA database was checked directly through MySQL.

The application successfully created and persisted the app_users table.

The following query was used to verify the demo accounts:

SELECT email, user_role FROM app_users;

The database returned:

admin@learnsphere.ca       ADMIN
instructor@learnsphere.ca  INSTRUCTOR
student@learnsphere.ca     STUDENT

This confirmed that the application was successfully persisting user information in the MySQL QA database.

Course Data Verification

The QA database was also checked for course persistence using:

SELECT COUNT(*) FROM courses;

The QA database initially contained:

0

courses because SQL initialization was intentionally disabled for the QA profile:

spring.sql.init.mode=never

This confirms that the QA environment uses the MySQL database directly rather than automatically loading the default SQL seed data.

H2 Console Verification

The H2 console was disabled in the QA environment using:

spring.h2.console.enabled=false

The /h2-console endpoint was tested while the QA profile was active.

The request did not provide access to the H2 console and was redirected to the application's login page.

This confirms that the H2 console is not available as a QA database interface.

QA Testing Summary

The following QA requirements were completed and verified:

Created a dedicated feature/deliverable3-qa-maheen branch.
Added MySQL Connector/J to the project.
Created the learnsphere_qa MySQL database.
Added the application-qa.properties Spring profile.
Configured Spring Boot to connect to MySQL in the QA environment.
Verified that the qa Spring profile is active when the application is started.
Verified a successful connection to the MySQL QA database.
Verified user persistence in MySQL.
Verified that H2 console access is disabled in QA.
Tested the application while running with the QA profile.
Deliverable 3 Contribution

Maheen Khan completed the QA/MySQL portion of Deliverable 3, including QA profile configuration, MySQL database setup, MySQL persistence verification, H2 console verification, and QA environment testing.

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