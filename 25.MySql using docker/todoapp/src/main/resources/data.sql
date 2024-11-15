INSERT INTO
    todo (DONE, TARGET_DATE, DESCRIPTION, USERNAME)
VALUES
    (FALSE, CURRENT_DATE, 'Get JAVA Certified', 'ms'),
    (
        FALSE,
        CURRENT_DATE,
        'Complete Spring Boot Project',
        'ms'
    ),
    (
        TRUE,
        DATEADD ('DAY', -3, CURRENT_DATE),
        'Update LinkedIn Profile',
        'john_doe'
    ),
    (
        FALSE,
        DATEADD ('DAY', 5, CURRENT_DATE),
        'Learn Docker Basics',
        'ms'
    ),
    (
        FALSE,
        DATEADD ('DAY', 10, CURRENT_DATE),
        'Practice Java Streams API',
        'jane_smith'
    ),
    (
        TRUE,
        DATEADD ('DAY', -1, CURRENT_DATE),
        'Review Git Best Practices',
        'ms'
    ),
    (
        FALSE,
        DATEADD ('DAY', 7, CURRENT_DATE),
        'Prepare for Java Interview',
        'alice_wonder'
    ),
    (
        FALSE,
        DATEADD ('DAY', 15, CURRENT_DATE),
        'Learn Spring Security',
        'ms'
    ),
    (
        TRUE,
        DATEADD ('DAY', -2, CURRENT_DATE),
        'Complete Java 17 Certification',
        'john_doe'
    ),
    (
        FALSE,
        DATEADD ('DAY', 3, CURRENT_DATE),
        'Read Clean Code Book',
        'jane_smith'
    ),
    (
        FALSE,
        CURRENT_DATE,
        'Set Up Jenkins Pipeline',
        'ms'
    ),
    (
        TRUE,
        DATEADD ('DAY', -7, CURRENT_DATE),
        'Deploy App to AWS',
        'alice_wonder'
    ),
    (
        FALSE,
        DATEADD ('DAY', 12, CURRENT_DATE),
        'Implement JPA Auditing',
        'ms'
    ),
    (
        FALSE,
        DATEADD ('DAY', 8, CURRENT_DATE),
        'Explore Microservices Architecture',
        'john_doe'
    ),
    (
        TRUE,
        DATEADD ('DAY', -5, CURRENT_DATE),
        'Refactor Old Codebase',
        'ms'
    ),
    (
        FALSE,
        DATEADD ('DAY', 2, CURRENT_DATE),
        'Research on Kubernetes',
        'alice_wonder'
    ),
    (
        TRUE,
        DATEADD ('DAY', -4, CURRENT_DATE),
        'Migrate Database to PostgreSQL',
        'jane_smith'
    ),
    (
        FALSE,
        DATEADD ('DAY', 6, CURRENT_DATE),
        'Set Up CI/CD Pipeline',
        'john_doe'
    ),
    (
        FALSE,
        DATEADD ('DAY', 9, CURRENT_DATE),
        'Implement OAuth2 Authentication',
        'ms'
    ),
    (
        TRUE,
        DATEADD ('DAY', -8, CURRENT_DATE),
        'Attend Java User Group Meetup',
        'alice_wonder'
    ),
    (
        FALSE,
        DATEADD ('DAY', 4, CURRENT_DATE),
        'Write Unit Tests for New Module',
        'jane_smith'
    ),
    (
        TRUE,
        DATEADD ('DAY', -6, CURRENT_DATE),
        'Optimize Application Performance',
        'john_doe'
    ),
    (
        FALSE,
        DATEADD ('DAY', 11, CURRENT_DATE),
        'Explore Azure Cloud Services',
        'ms'
    ),
    (
        FALSE,
        DATEADD ('DAY', 1, CURRENT_DATE),
        'Prepare for Tech Conference Talk',
        'alice_wonder'
    ),
    (
        TRUE,
        DATEADD ('DAY', -9, CURRENT_DATE),
        'Finish Python for Data Science Course',
        'jane_smith'
    );