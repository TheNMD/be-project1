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


-- Other
ALTER TABLE courses 
	ADD COLUMN teacher_id BIGINT,
	ADD FOREIGN KEY(teacher_id) references teachers(id);

ALTER TABLE chapters 
	ADD COLUMN course_id BIGINT,
	ADD FOREIGN KEY(course_id) references courses(id);

ALTER TABLE lessons 
	ADD COLUMN chapter_id BIGINT,
	ADD FOREIGN KEY(chapter_id) references chapters(id);

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