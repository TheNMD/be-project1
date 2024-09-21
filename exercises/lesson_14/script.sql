-- PostgreSQL

-- Entities
CREATE TABLE students 
(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	age INT,
	grade INT
);

CREATE TABLE classes 
(
	id BIGSERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL
);

-- Relationships
CREATE TABLE students_classes
(
	student_id BIGINT,
	FOREIGN KEY(student_id) references students(id),
	class_id BIGINT,
	FOREIGN KEY(class_id) references classes(id),
	score NUMERIC
);

-- VALUES
INSERT INTO students (name, age, grade)
	VALUES ('Nguyen Van A', 16, 10);

INSERT INTO classes (title)
	VALUES ('Math');
INSERT INTO classes (title)
	VALUES ('Literature');
INSERT INTO classes (title)
	VALUES ('English');
INSERT INTO classes (title)
	VALUES ('Physics');
INSERT INTO classes (title)
	VALUES ('Chemistry');
INSERT INTO classes (title)
	VALUES ('Biology');
INSERT INTO classes (title)
	VALUES ('History');
INSERT INTO classes (title)
	VALUES ('Geography');

-- SELECT
-- Q1
SELECT students.name AS student_name, courses.title AS course_title
	FROM students 
	INNER JOIN students_courses ON students.id = students_courses.student_id
	INNER JOIN courses ON courses.id = students_courses.course_id
	ORDER BY students.id;

SELECT students.name AS student_name, COUNT(students_courses.course_id) AS num_courses
	FROM students 
	LEFT JOIN students_courses ON students.id = students_courses.student_id
	GROUP BY students.id
	ORDER BY students.id;

-- Q2
SELECT teachers.name AS teacher_name, courses.title AS course_title
	FROM teachers 
	LEFT JOIN courses ON teachers.id = courses.teacher_id
	ORDER BY teachers.id;

-- Other
SELECT * FROM students ;
SELECT * FROM classes ;
SELECT * FROM students_classes ;

DROP TABLE students CASCADE;
DROP TABLE classes CASCADE;
DROP TABLE students_classes CASCADE;