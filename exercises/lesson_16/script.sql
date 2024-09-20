-- PostgreSQL

-- Entities
CREATE TABLE students 
(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	status VARCHAR(50) NOT NULL
);

CREATE TABLE teachers 
(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	status VARCHAR(50) NOT NULL
);

CREATE TABLE courses 
(
	id BIGSERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description VARCHAR(255),
	credit INT
);

CREATE TABLE chapters 
(
	id BIGSERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description VARCHAR(255)
);

CREATE TABLE lessons 
(
	id BIGSERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	description VARCHAR(255)
);

CREATE TABLE admin 
(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL
);

-- Relationships
CREATE TABLE students_courses 
(
	student_id BIGINT,
	FOREIGN KEY(student_id) references students(id),
	course_id BIGINT,
	FOREIGN KEY(course_id) references courses(id),
	score NUMERIC,
	rating NUMERIC
);

ALTER TABLE courses 
	ADD COLUMN teacher_id BIGINT,
	ADD FOREIGN KEY(teacher_id) references teachers(id);

ALTER TABLE chapters 
	ADD COLUMN course_id BIGINT,
	ADD FOREIGN KEY(course_id) references courses(id);

ALTER TABLE lessons 
	ADD COLUMN chapter_id BIGINT,
	ADD FOREIGN KEY(chapter_id) references chapters(id);

-- VALUES
INSERT INTO students (name, status)
	VALUES ('Nguyen Van A', 'Studying');
INSERT INTO students (name, status)
	VALUES ('Tran Thi B', 'DropOut');
INSERT INTO students (name, status)
	VALUES ('Nguyen Vu C', 'Studying');
INSERT INTO students (name, status)
	VALUES ('Nguyen Dong D', 'Studying');
INSERT INTO students (name, status)
	VALUES ('Le Thi E', 'OnHold');
INSERT INTO students (name, status)
	VALUES ('Ngo Thi F', 'Studying');
INSERT INTO students (name, status)
	VALUES ('Nguyen Ha G', 'OnHold');
INSERT INTO students (name, status)
	VALUES ('Truong Thi H', 'Studying');
INSERT INTO students (name, status)
	VALUES ('Ho Thi I', 'Studying');
INSERT INTO students (name, status)
	VALUES ('Lam Trieu J', 'OnHold');
INSERT INTO students (name, status)
	VALUES ('Nguyen Ngoc K', 'Studying');
INSERT INTO students (name, status)
	VALUES ('Truong Tam L', 'Studying');
INSERT INTO students (name, status)
	VALUES ('Ngo Cong M', 'Studying');
INSERT INTO students (name, status)
	VALUES ('Le Van N', 'DropOut');
INSERT INTO students (name, status)
	VALUES ('Tran Dinh O', 'DropOut');
INSERT INTO students (name, status)
	VALUES ('Ngo Thien P', 'Studying');

INSERT INTO teachers (name, status)
	VALUES ('Tran Que A', 'OnBusinessTrip');
INSERT INTO teachers (name, status)
	VALUES ('Tran Thu B', 'Teaching');
INSERT INTO teachers (name, status)
	VALUES ('Truong Van C', 'Teaching');
INSERT INTO teachers (name, status)
	VALUES ('Le Thanh D', 'Resigned');
INSERT INTO teachers (name, status)
	VALUES ('Do Duc E', 'Resigned');
INSERT INTO teachers (name, status)
	VALUES ('Ngo Dinh F', 'Teaching');
INSERT INTO teachers (name, status)
	VALUES ('Lam Gia G', 'Teaching');
INSERT INTO teachers (name, status)
	VALUES ('Do Thi Thu H', 'OnBusinessTrip');
INSERT INTO teachers (name, status)
	VALUES ('Ha Khanh I', 'Teaching');
INSERT INTO teachers (name, status)
	VALUES ('Nguyen Vuong J', 'OnBusinessTrip');

INSERT INTO courses (title, description, credit, teacher_id)
	VALUES ('Intro to Programming', 'CS', 3, 3);
INSERT INTO courses (title, description, credit, teacher_id)
	VALUES ('Linear Algebra', 'General', 2, 2);
INSERT INTO courses (title, description, credit, teacher_id)
	VALUES ('Database Systems', 'CS', 3, 2);
INSERT INTO courses (title, description, credit, teacher_id)
	VALUES ('Computer Architecture', 'CE', 3, 8);
INSERT INTO courses (title, description, credit, teacher_id)
	VALUES ('Intro to AI', 'CS', 3, 10);
INSERT INTO courses (title, description, credit, teacher_id)
	VALUES ('Game Programming', 'CS', 3, 8);
INSERT INTO courses (title, description, credit, teacher_id)
	VALUES ('Digital Systems', 'CE', 3, 10);
INSERT INTO courses (title, description, credit, teacher_id)
	VALUES ('Computer Networks', 'CS', 3, 6);
INSERT INTO courses (title, description, credit, teacher_id)
	VALUES ('Physical Education', 'General', 2, 1);
INSERT INTO courses (title, description, credit)
	VALUES ('Robotics', 'CE', 3);

INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 1);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 1);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 2);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 2);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 3);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 3);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 4);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 4);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 5);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 5);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 6);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 6);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 7);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 7);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 8);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 8);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 9);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 9);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 1', 'Basic', 10);
INSERT INTO chapters (title, description, course_id)
	VALUES ('Chapter 2', 'Advanced', 10);

INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 1);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 1);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 2);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 3);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 3);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 4);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 5);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 5);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 6);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 7);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 7);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 8);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 9);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 9);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 10);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 11);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 11);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 12);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 13);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 13);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 14);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 15);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 15);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 16);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 17);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 17);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 18);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Intro', 'Course Information', 19);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 1', 'Recap', 19);
INSERT INTO lessons (title, description, chapter_id)
	VALUES ('Lesson 10', 'Test', 20);

INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (1, 7, 7.2, 4.3);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (1, 3, 7.5, 4.1);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (1, 1, 8.3, 4.6);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (1, 8, 6.9, 3.8);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (2, 1, 4.3, 3.6);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (2, 7, 5.6, 3.4);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (2, 2, 6.4, 3.1);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (3, 3, 8.3, 4.8);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (3, 4, 6.8, 3.3);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (3, 5, 9.2, 4.9);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (3, 1, 8.7, 4.6);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (3, 9, 7.7, 4.4);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (4, 9, 6.0, 3.1);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (4, 8, 6.5, 3.5);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (4, 1, 8.5, 4.5);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (5, 5, 9.0, 5.0);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (5, 5, 8.4, 4.8);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (5, 4, 7.4, 4.0);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (5, 8, 8.2, 4.3);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (5, 1, 8.2, 4.4);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (6, 9, 3.0, 2.0);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (6, 2, 6.2, 3.6);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (6, 1, 7.8, 4.3);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (6, 2, 3.4, 4.3);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (7, 4, 8.4, 4.4);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (7, 4, 8.7, 4.5);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (7, 5, 7.2, 4.0);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (7, 1, 6.4, 4.0);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (8, 7, 9.0, 5.0);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (8, 7, 6.2, 3.5);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (8, 9, 7.7, 3.7);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (8, 9, 8.7, 4.2);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (8, 1, 8.2, 4.9);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (9, 3, 8.8, 4.9);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (9, 5, 9.2, 5.0);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (9, 1, 7.0, 4.0);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (9, 5, 6.5, 3.8);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (10, 2, 3.1, 1.3);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (10, 1, 7.1, 4.2);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (11, 1, 2.1, 2.1);
INSERT INTO students_courses (student_id, course_id, score, rating)
	VALUES (11, 4, 6.1, 3.4);

-- SELECT
-- Q1
SELECT students.name AS student_name, courses.title AS course_title
	FROM students 
	INNER JOIN students_courses ON students.id = students_courses.student_id
	INNER JOIN courses ON courses.id = students_courses.course_id
	ORDER BY students.id;

SELECT students.name AS student_name, COUNT(courses.id) AS num_courses
	FROM students 
	INNER JOIN students_courses ON students.id = students_courses.student_id
	INNER JOIN courses ON courses.id = students_courses.course_id
	GROUP BY students.id
	ORDER BY students.id;

-- Q2
SELECT teachers.name AS teacher_name, courses.title AS course_title
	FROM teachers 
	LEFT JOIN courses ON teachers.id = courses.teacher_id
	ORDER BY teachers.id;

-- Q3
WITH 
	temp_table AS
	(
		SELECT courses.title AS course_title, COUNT(students.id) AS num_students, ROUND(AVG(students_courses.rating), 1) AS course_rating
			FROM courses 
			INNER JOIN students_courses ON courses.id = students_courses.course_id
			INNER JOIN students ON students.id = students_courses.student_id
			GROUP BY courses.id
			ORDER BY courses.id
	)
SELECT *
	FROM temp_table
	WHERE num_students > 10  AND course_rating >= 4.0;

-- Q4
SELECT courses.title AS course_title, chapters.title AS chapter_title, lessons.title AS lesson_title 
	FROM courses 
	INNER JOIN chapters ON courses.id = chapters.course_id
	INNER JOIN lessons ON chapters.id = lessons.chapter_id
	ORDER BY courses.id;

-- Q5
WITH 
	temp_table AS
	(
		SELECT courses.teacher_id AS teacher_id, courses.title AS course_title, COUNT(students.id) AS num_students
			FROM courses
			LEFT JOIN students_courses ON courses.id = students_courses.course_id
			LEFT JOIN students ON students.id = students_courses.student_id
			GROUP BY courses.id
			ORDER BY courses.id
	)
SELECT temp_table.course_title, teachers.name AS teacher_name, temp_table.num_students
	FROM temp_table
	LEFT JOIN teachers ON teachers.id = temp_table.teacher_id
	WHERE teachers.name IS NULL OR temp_table.num_students = 0;

-- Q6
SELECT courses.title AS course_title, COUNT(DISTINCT chapters.id) AS num_chapters, COUNT(DISTINCT lessons.id) AS num_lessons, COUNT(DISTINCT students.id) AS num_students
	FROM courses
	INNER JOIN chapters ON courses.id = chapters.course_id
	INNER JOIN lessons ON chapters.id = lessons.chapter_id
	LEFT JOIN students_courses ON courses.id = students_courses.course_id
	LEFT JOIN students ON students.id = students_courses.student_id
	GROUP BY courses.id
	ORDER BY courses.id;

-- Q7
SELECT courses.title AS course_title, chapters.title AS chapter_title, COUNT(lessons.id) AS num_lessons
	FROM courses
	INNER JOIN chapters ON courses.id = chapters.course_id
	INNER JOIN lessons ON chapters.id = lessons.chapter_id
	GROUP BY chapters.id, courses.id
	ORDER BY courses.id;

-- Q8 & Q9
SELECT students.name AS student_name, courses.title AS course_title, chapters.title AS chapter_title, lessons.title AS lesson_title
	FROM students
	INNER JOIN students_courses ON students.id = students_courses.student_id
	INNER JOIN courses ON courses.id = students_courses.course_id
	INNER JOIN chapters ON courses.id = chapters.course_id
	INNER JOIN lessons ON chapters.id = lessons.chapter_id
	ORDER BY students.id;

-- Create a students_lessons table
CREATE TABLE students_lessons AS
	SELECT students.id AS student_id, lessons.id AS lesson_id
		FROM students
		INNER JOIN students_courses ON students.id = students_courses.student_id
		INNER JOIN courses ON courses.id = students_courses.course_id
		INNER JOIN chapters ON courses.id = chapters.course_id
		INNER JOIN lessons ON chapters.id = lessons.chapter_id
		ORDER BY students.id, lessons.id;
		
ALTER TABLE students_lessons 
	ADD FOREIGN KEY(student_id) references students(id),
	ADD FOREIGN KEY(lesson_id) references lessons(id),
	ADD COLUMN status varchar(20);

-- Add values to the status column of the students_lessons table
UPDATE students_lessons
	SET status = CASE
	    WHEN lesson_id % 3 = 0 THEN 'NotYet'
	    WHEN lesson_id % 3 = 1 THEN 'Finished'
		WHEN lesson_id % 3 = 2 THEN 'Studying'
	END;

-- Count number of students that have finished a lessons.
WITH
	temp_table AS
	(
		SELECT
			lesson_id,
		    SUM(CASE WHEN students_lessons.status = 'Finished' THEN 1 ELSE 0 END) AS num_Finish,
		    SUM(CASE WHEN students_lessons.status = 'Studying' THEN 1 ELSE 0 END) AS num_Studying,
		    SUM(CASE WHEN students_lessons.status = 'NotYet' THEN 1 ELSE 0 END) AS num_NotYet
			FROM students_lessons
			GROUP BY lesson_id
			ORDER BY lesson_id
	)
SELECT courses.title AS course_title, chapters.title AS chapter_title, lessons.title AS lesson_title, num_Finish, num_Studying, num_NotYet
	FROM courses
	INNER JOIN chapters ON courses.id = chapters.course_id
	INNER JOIN lessons ON chapters.id = lessons.chapter_id
	INNER JOIN temp_table ON lessons.id = temp_table.lesson_id
	ORDER BY courses.id, chapters.id;

-- Other
SELECT * FROM students ;
SELECT * FROM teachers ;
SELECT * FROM courses ;
SELECT * FROM chapters ;
SELECT * FROM lessons ;
SELECT * FROM students_courses ;
SELECT * FROM students_lessons ;

DROP TABLE students CASCADE;
DROP TABLE teachers CASCADE;
DROP TABLE courses CASCADE;
DROP TABLE chapters CASCADE;
DROP TABLE lessons CASCADE;
DROP TABLE admin CASCADE;
DROP TABLE students_courses CASCADE;
DROP TABLE students_lessons CASCADE;