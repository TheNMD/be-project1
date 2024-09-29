-- PostgreSQL

-- Entities
CREATE TABLE students 
(
	id BIGSERIAL PRIMARY KEY,
	lastname VARCHAR(255) NOT NULL,
	midname VARCHAR(255),
	firstname VARCHAR(255) NOT NULL,
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

-- Other
SELECT * FROM students ORDER BY students.id;
SELECT * FROM classes ORDER BY classes.id;
SELECT * FROM students_classes ORDER BY students_classes.student_id;

DROP TABLE students CASCADE;
DROP TABLE classes CASCADE;
DROP TABLE students_classes CASCADE;