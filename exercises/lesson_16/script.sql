-- PostgreSQL

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

-- Q3
WITH 
	temp_table AS
	(
		SELECT courses.title AS course_title, COUNT(students_courses.student_id) AS num_students, ROUND(AVG(students_courses.rating), 1) AS course_rating
			FROM courses 
			LEFT JOIN students_courses ON courses.id = students_courses.course_id
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
		SELECT courses.teacher_id AS teacher_id, courses.title AS course_title, COUNT(students_courses.student_id) AS num_students
			FROM courses
			LEFT JOIN students_courses ON courses.id = students_courses.course_id
			GROUP BY courses.id
			ORDER BY courses.id
	)
SELECT temp_table.course_title, teachers.name AS teacher_name, temp_table.num_students
	FROM temp_table
	LEFT JOIN teachers ON teachers.id = temp_table.teacher_id
	WHERE teachers.name IS NULL OR temp_table.num_students = 0;

-- Q6
SELECT courses.title AS course_title, COUNT(DISTINCT chapters.id) AS num_chapters, COUNT(DISTINCT lessons.id) AS num_lessons, COUNT(DISTINCT students_courses.student_id) AS num_students
	FROM courses
	INNER JOIN chapters ON courses.id = chapters.course_id
	INNER JOIN lessons ON chapters.id = lessons.chapter_id
	LEFT JOIN students_courses ON courses.id = students_courses.course_id
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
	LEFT JOIN students_courses ON students.id = students_courses.student_id
	LEFT JOIN courses ON courses.id = students_courses.course_id
	LEFT JOIN chapters ON courses.id = chapters.course_id
	LEFT JOIN lessons ON chapters.id = lessons.chapter_id
	ORDER BY students.id;

-- Create a students_lessons table
CREATE TABLE students_lessons AS
	SELECT students.id AS student_id, lessons.id AS lesson_id
		FROM students
		LEFT JOIN students_courses ON students.id = students_courses.student_id
		LEFT JOIN chapters ON students_courses.course_id = chapters.course_id
		LEFT JOIN lessons ON chapters.id = lessons.chapter_id
		ORDER BY students.id;

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
	LEFT JOIN chapters ON courses.id = chapters.course_id
	LEFT JOIN lessons ON chapters.id = lessons.chapter_id
	LEFT JOIN temp_table ON lessons.id = temp_table.lesson_id
	ORDER BY courses.id, chapters.id;
