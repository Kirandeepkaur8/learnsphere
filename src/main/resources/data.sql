MERGE INTO courses
    (course_code, title, instructor_name, category, difficulty,
    duration_weeks, price, description, created_at)
    KEY(course_code)
    VALUES
    ('WEB-101', 'HTML CSS and Responsive Design', 'Avery Chen',
    'WEB_DEVELOPMENT', 'BEGINNER', 6, 49.00,
    'Build accessible and responsive websites using HTML CSS and Bootstrap.',
    CURRENT_TIMESTAMP);

MERGE INTO courses
    (course_code, title, instructor_name, category, difficulty,
    duration_weeks, price, description, created_at)
    KEY(course_code)
    VALUES
    ('JAV-201', 'Object-Oriented Java', 'Marcus Brown',
    'PROGRAMMING', 'INTERMEDIATE', 8, 79.00,
    'Develop maintainable Java applications using classes interfaces and collections.',
    CURRENT_TIMESTAMP);

MERGE INTO courses
    (course_code, title, instructor_name, category, difficulty,
    duration_weeks, price, description, created_at)
    KEY(course_code)
    VALUES
    ('DBS-110', 'Database Foundations with SQL', 'Priya Sharma',
    'DATABASES', 'BEGINNER', 7, 59.00,
    'Learn relational modelling SQL queries joins constraints and database design.',
    CURRENT_TIMESTAMP);

MERGE INTO courses
    (course_code, title, instructor_name, category, difficulty,
    duration_weeks, price, description, created_at)
    KEY(course_code)
    VALUES
    ('DAT-250', 'Applied Data Analytics', 'Sofia Martinez',
    'DATA_SCIENCE', 'INTERMEDIATE', 10, 99.00,
    'Transform datasets into useful insights through analysis and visualization.',
    CURRENT_TIMESTAMP);

MERGE INTO courses
    (course_code, title, instructor_name, category, difficulty,
    duration_weeks, price, description, created_at)
    KEY(course_code)
    VALUES
    ('SEC-305', 'Web Application Security', 'Noah Williams',
    'CYBERSECURITY', 'ADVANCED', 9, 129.00,
    'Identify web vulnerabilities and apply secure application development practices.',
    CURRENT_TIMESTAMP);

MERGE INTO courses
    (course_code, title, instructor_name, category, difficulty,
    duration_weeks, price, description, created_at)
    KEY(course_code)
    VALUES
    ('BUS-120', 'Digital Project Essentials', 'Emma Taylor',
    'BUSINESS', 'BEGINNER', 5, 39.00,
    'Plan digital projects using scope scheduling risk and communication techniques.',
    CURRENT_TIMESTAMP);

MERGE INTO courses
    (course_code, title, instructor_name, category, difficulty,
    duration_weeks, price, description, created_at)
    KEY(course_code)
    VALUES
    ('SPR-320', 'Spring Boot Web Applications', 'Daniel Kim',
    'WEB_DEVELOPMENT', 'ADVANCED', 12, 149.00,
    'Create Spring Boot applications with MVC Thymeleaf validation and JPA.',
    CURRENT_TIMESTAMP);

MERGE INTO courses
    (course_code, title, instructor_name, category, difficulty,
    duration_weeks, price, description, created_at)
    KEY(course_code)
    VALUES
    ('PYT-140', 'Python Programming Fundamentals', 'Olivia Singh',
    'PROGRAMMING', 'BEGINNER', 8, 69.00,
    'Practice Python functions collections files and problem-solving techniques.',
    CURRENT_TIMESTAMP);