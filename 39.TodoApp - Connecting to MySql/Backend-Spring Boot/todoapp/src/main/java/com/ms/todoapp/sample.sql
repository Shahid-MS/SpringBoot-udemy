Create database TodoDb;
show databases;

use tododb;
select * from todo;

INSERT INTO
    Todo (DONE, TARGET_DATE, DESCRIPTION, USERNAME)
VALUES
    (
        false,
        '2024-12-15',
        'Complete the Spring Boot assignment',
        'ms@gmail.com'
    ),
    (
        true,
        '2024-12-20',
        'Review the project plan',
        'john_doe'
    ),
    (
        false,
        '2024-12-22',
        'Prepare for the team meeting',
        'ms@gmail.com'
    ),
    (
        true,
        '2024-12-25',
        'Submit the budget report',
        'jane_smith'
    ),
    (
        false,
        '2025-01-05',
        'Draft the annual review document',
        'michael_b'
    ),
    (
        true,
        '2025-01-10',
        'Update the system configurations',
        'ms@gmail.com'
    );