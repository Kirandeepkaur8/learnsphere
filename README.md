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