-- PostgreSQL

-- Inserting sample data into the admin table
INSERT INTO admin_entity (status, username, password, created_date, updated_date)
	VALUES ('active', 'admin1', 'hashed_password_1', NOW(), NULL),
       	   ('active', 'admin2', 'hashed_password_2', NOW(), NULL);

-- Inserting sample data into the teacher table
INSERT INTO teacher_entity (name, status, username, password, created_date, updated_date)
	VALUES ('John Anderson', 'active', 'j_anderson', 'hashed_password_1', NOW(), NULL),
           ('Sarah Johnson', 'active', 's_jonhson', 'hashed_password_2', NOW(), NULL),
           ('Luke Williams', 'active', 'luke_w', 'hashed_password_2', NOW(), NULL);

-- Inserting sample data into the student table
INSERT INTO user_entity (name, status, username, password, created_date, updated_date)
	VALUES ('John Doe', 'active', 'johndoe', 'hashed_password_1', NOW(), NULL),
           ('Jane Smith', 'active', 'janesmith', 'hashed_password_2', NOW(), NULL),
           ('Alice Brown',  'inactive', 'alicebrown', 'hashed_password_3', NOW(), NULL),
           ('Lindsey Xanders',  'inactive', 'lindesey_X', 'hashed_password_4', NOW(), NULL);

-- Inserting sample data into the course table
INSERT INTO course_entity (name, description, status, created_date, updated_date, teacher_id)
	VALUES ('Introduction to Programming', 'Learn the basics of programming using Java.', 'active', NOW(), NULL, 1),
           ('Web Development Basics', 'An introduction to HTML, CSS, and JavaScript.', 'active', NOW(), NULL, 2),
           ('Data Structures and Algorithms', 'Understand essential data structures and algorithms.', 'inactive', NOW(), null, 3),
           ('Kafka', 'kafka', 'inactive', NOW(), NULL, null);

-- Inserting sample data into the chapter table
INSERT INTO chapter_entity (name, description, status, chapter_order, created_date, updated_date, course_id)
	VALUES ('Getting Started with Java', 'Introduction to Java programming language.', 'active', 1, NOW(), NULL, 1),
           ('HTML Basics', 'Understanding the structure of a webpage.', 'active', 1, NOW(), NULL, 2),
           ('Sorting Algorithms', 'Learn about different sorting algorithms.', 'inactive', 1, NOW(), NULL, 3);

-- Inserting sample data into the lesson table
INSERT INTO lesson_entity (name, description, status, type, url, lesson_order, created_date, updated_date, chapter_id)
	VALUES ('Setting Up Java', 'How to install and configure Java.', 'active', 'video', 'http://example.com/java-setup', 1, NOW(), NULL, 1),
       	   ('Creating Your First HTML Page', 'Step by step guide to create an HTML page.', 'active', 'video', 'http://example.com/html-first-page', 1, NOW(), NULL, 2),
       	   ('Bubble Sort', 'Explaining bubble sort algorithm with examples.', 'inactive', 'video', 'http://example.com/bubble-sort', 1, NOW(), NULL, 3);

-- Inserting sample data into the student_course table
INSERT INTO user_course_entity (student_id, course_id, rating, review, status, created_date, updated_date)
	VALUES (1, 1, 5, 'Great course! Very informative.', 'active', NOW(), NULL),
           (1, 2, 4, 'Good introduction, but could use more examples.', 'active', NOW(), NULL),
           (2, 1, 3, 'Decent course, but not engaging.', 'active', NOW(), NULL),
           (3, 3, NULL, NULL, 'inactive', NOW(), NULL);

-- Inserting sample data into the student_course_lesson table
INSERT INTO user_course_lesson_entity (uc_user_id, uc_course_id, lesson_id, status, created_date, updated_date)
	VALUES (1, 1, 1, 'completed', NOW(), NULL),
       	   (1, 2, 2, 'in_progress', NOW(), NULL),
       	   (2, 1, 1, 'not_started', NOW(), NULL),
       	   (1, 3, 3, 'completed', NOW(), NULL);
