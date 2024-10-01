-- PostgreSQL

-- Select a schema
SET search_path TO pet_project;

-- Users - Admin
-- Add
INSERT INTO admin (status, username, password, created_date, updated_date)
	VALUES ('active', 'admin3', 'hashed_password', NOW(), NULL);
-- Delete
DELETE FROM admin WHERE id = 3;
-- Update
UPDATE admin
	SET password = 'not_a_real_password', updated_date = NOW()
	WHERE id = 2;
-- View
SELECT * 
	FROM admin
	WHERE admin.username = 'admin1'
	ORDER BY admin.id
	LIMIT 10 OFFSET 0;
SELECT * 
	FROM admin
	WHERE admin.created_date > '2024-01-01 00:00:00' AND admin.created_date < '2024-12-01 00:00:00'
	ORDER BY admin.id
	LIMIT 10 OFFSET 0;

-- Users - Students
-- Add
INSERT INTO student (name, status, age, username, password, created_date, updated_date)
	VALUES  ('Random User', 'active', 18, 'randUser', 'hashed_password', NOW(), NULL);
-- Delete
DELETE FROM student WHERE id = 5;
-- Update
UPDATE student
	SET password = 'not_a_real_password', updated_date = NOW()
	WHERE id = 4;
-- View
-- By username
SELECT * 
	FROM student
	WHERE student.username = 'johndoe'
	ORDER BY student.id
	LIMIT 10 OFFSET 0;
-- By name
SELECT * 
	FROM student
	WHERE student.name = 'John Doe'
	ORDER BY student.id
	LIMIT 10 OFFSET 0;
-- By status
SELECT * 
	FROM student
	WHERE student.status = 'active'
	ORDER BY student.id
	LIMIT 10 OFFSET 0;
-- By created date
SELECT * 
	FROM student
	WHERE student.created_date > '2024-01-01 00:00:00' AND student.created_date < '2024-12-01 00:00:00'
	ORDER BY student.id
	LIMIT 10 OFFSET 0;
	
-- Users - Teachers
-- Add
INSERT INTO teacher (name, status, username, password, created_date, updated_date)
	VALUES  ('Random Teacher', 'active', 'randTeacher', 'hashed_password', NOW(), NULL);
-- Delete
DELETE FROM teacher WHERE id = 4;
-- Update
UPDATE teacher
	SET password = 'not_a_real_password', updated_date = NOW()
	WHERE id = 3;
-- View
-- By username
SELECT * 
	FROM teacher
	WHERE teacher.username = 'mr_anderson'
	ORDER BY teacher.id
	LIMIT 10 OFFSET 0;
-- By name
SELECT * 
	FROM teacher
	WHERE teacher.name = 'Mr. Anderson'
	ORDER BY teacher.id
	LIMIT 10 OFFSET 0;
-- By status
SELECT * 
	FROM teacher
	WHERE teacher.status = 'active'
	ORDER BY teacher.id
	LIMIT 10 OFFSET 0;
-- By created date 
SELECT * 
	FROM teacher
	WHERE teacher.created_date > '2024-01-01 00:00:00' AND teacher.created_date < '2024-12-01 00:00:00'
	ORDER BY teacher.id
	LIMIT 10 OFFSET 0;

-- Courses
-- Add
INSERT INTO course (name, description, status, created_date, updated_date, teacher_id)
	VALUES  ('Random Course', 'Random Description', 'active', NOW(), NULL, 1);
-- Delete
DELETE FROM course WHERE id = 5;
-- Update
UPDATE course
	SET description = 'some_description', updated_date = NOW()
	WHERE id = 4;
-- View
-- By name
SELECT * 
	FROM course
	WHERE course.name = 'Introduction to Programming'
	ORDER BY course.id
	LIMIT 10 OFFSET 0;
-- By status
SELECT * 
	FROM course
	WHERE course.status = 'active'
	ORDER BY course.id
	LIMIT 10 OFFSET 0;
-- By teacher name
SELECT course.id, course.name, course.description, course.status, course.created_date, course.updated_date, teacher.name AS teacher_name
	FROM course
	INNER JOIN teacher ON course.teacher_id = teacher.id
	WHERE teacher.name = 'Mr. Anderson'
	ORDER BY course.id
	LIMIT 10 OFFSET 0;
-- By created date
SELECT * 
	FROM course
	WHERE course.created_date > '2024-01-01 00:00:00' AND course.created_date < '2024-12-01 00:00:00'
	ORDER BY course.id
	LIMIT 10 OFFSET 0;
-- By average rating
SELECT course.id, course.name, course.description, course.status, course.created_date, course.updated_date, ROUND(AVG(student_course.rating), 2) AS rating
	FROM course
	INNER JOIN student_course ON course.id = student_course.course_id
	GROUP BY course.id
	HAVING AVG(student_course.rating) > 3.0
	ORDER BY course.id
	LIMIT 10 OFFSET 0;

-- Chapters
-- Add
INSERT INTO chapter (name, description, status, "order", created_date, updated_date, course_id)
	VALUES ('Random Chapter', 'Random Description', 'active', 1, NOW(), NULL, 1);
-- Delete
DELETE FROM chapter WHERE id = 4;
-- Update
UPDATE chapter
	SET description = 'some_description', updated_date = NOW()
	WHERE id = 3;
-- View
-- By name
SELECT * 
	FROM chapter
	WHERE chapter.name = 'Getting Started with Java'
	ORDER BY chapter.id
	LIMIT 10 OFFSET 0;
-- By status
SELECT * 
	FROM chapter
	WHERE chapter.status = 'active'
	ORDER BY chapter.id
	LIMIT 10 OFFSET 0;
-- By course name
SELECT chapter.id, chapter.name, chapter.description, chapter.status, chapter.order, chapter.created_date, chapter.updated_date, course.name AS course_name
	FROM chapter
	INNER JOIN course ON chapter.id = course.id
	WHERE course.name = 'Introduction to Programming'
	ORDER BY chapter.id
	LIMIT 10 OFFSET 0;
-- By created date
SELECT * 
	FROM chapter
	WHERE chapter.created_date > '2024-01-01 00:00:00' AND chapter.created_date < '2024-12-01 00:00:00'
	ORDER BY chapter.id
	LIMIT 10 OFFSET 0;

-- Lessons
-- Add
INSERT INTO lesson (name, description, status, type, url, "order", created_date, updated_date, chapter_id)
	VALUES ('Random Lesson', 'Random Description', 'active', 'video', 'http://example.com/random-link', 1, NOW(), NULL, 4);
-- Delete
DELETE FROM chapter WHERE id = 4;
-- Update
UPDATE chapter
	SET description = 'some_description', updated_date = NOW()
	WHERE id = 3;
-- View
-- By name
SELECT * 
	FROM lesson
	WHERE lesson.name = 'Setting Up Java'
	ORDER BY lesson.id
	LIMIT 10 OFFSET 0;
-- By status
SELECT * 
	FROM lesson
	WHERE lesson.status = 'active'
	ORDER BY lesson.id
	LIMIT 10 OFFSET 0;
-- By course name
SELECT lesson.id, lesson.name, lesson.description, lesson.status, lesson.type, lesson.url, lesson.order, lesson.created_date, lesson.updated_date, chapter.name AS chapter_name, course.name AS course_name
	FROM lesson
	INNER JOIN chapter ON lesson.id = chapter.id
	INNER JOIN course ON chapter.id = course.id
	WHERE chapter.name = 'Getting Started with Java'
	ORDER BY lesson.id
	LIMIT 10 OFFSET 0;
-- By chapter name
SELECT * 
	FROM lesson
	WHERE lesson.type = 'video'
	ORDER BY lesson.id
	LIMIT 10 OFFSET 0;
-- By created date
SELECT * 
	FROM lesson
	WHERE lesson.created_date > '2024-01-01 00:00:00' AND lesson.created_date < '2024-12-01 00:00:00'
	ORDER BY lesson.id
	LIMIT 10 OFFSET 0;

-- Special view
-- Students with number of courses
SELECT student.id, student.name, student.status, student.age, student.created_date, student.updated_date, COUNT(course_id) AS num_course
	FROM student
	INNER JOIN student_course ON student.id = student_course.student_id
	GROUP BY student.id
	ORDER BY student.id
	LIMIT 10 OFFSET 0;

-- Students and Courses with number of student being finished or still progressing the lessons
-- TODO

-- Student and Course and Lesson
SELECT student.id, student.name, student.status, student.age, student.created_date, student.updated_date,
	   course.id AS course_id, course.name AS course_name, course.description AS course_description, course.status AS course_status, course.created_date AS course_created_date, course.updated_date AS course_updated_date, course.teacher_id,
	   lesson.id AS lesson_id, lesson.name AS lesson_name, lesson.description AS lesson_description, lesson.status AS lesson_status, lesson.type, lesson.url, lesson.order, lesson.created_date AS lesson_created_date, lesson.updated_date AS lesson_updated_date, lesson.chapter_id,
	   student_course_lesson.status AS studying_status
	FROM student
	INNER JOIN student_course_lesson ON student.id = student_course_lesson.user_course_user_id
	INNER JOIN course ON course.id = student_course_lesson.user_course_course_id
	INNER JOIN lesson ON lesson.id = student_course_lesson.lesson_id
	ORDER BY student.id
	LIMIT 10 OFFSET 0;

-- Teachers with number of courses
SELECT teacher.id, teacher.name, teacher.status, teacher.created_date, teacher.updated_date, COUNT(course.id) AS num_course
	FROM teacher
	INNER JOIN course ON teacher.id = course.teacher_id
	GROUP BY teacher.id
	ORDER BY teacher.id
	LIMIT 10 OFFSET 0;

-- Course with number of chapters and number of lessons and number of students
SELECT course.id, course.name, course.description, course.status, course.created_date, course.updated_date, course.teacher_id, 
	   COUNT(DISTINCT chapter.id) AS num_chapter, COUNT(DISTINCT lesson.id) AS num_lesson, COUNT(DISTINCT student_course.student_id) AS num_student
	FROM course
	INNER JOIN chapter ON course.id = chapter.course_id
	INNER JOIN lesson ON chapter.id = lesson.chapter_id
	INNER JOIN student_course ON course.id = student_course.course_id
	GROUP BY course.id
	ORDER BY course.id
	LIMIT 10 OFFSET 0;

-- Course and Chapter with number of lessons
SELECT course.id, course.name, course.description, course.status, course.created_date, course.updated_date, course.teacher_id,
	   chapter.id AS chapter_id, chapter.name AS chapter_name, chapter.description AS chapter_description, 
	   chapter.status AS chapter_status, chapter.order AS chapter_order, 
	   chapter.created_date AS chapter_created_date, chapter.updated_date AS chapter_updated_date, chapter.course_id,
	   COUNT(DISTINCT lesson.id) AS num_lesson
	FROM course
	INNER JOIN chapter ON course.id = chapter.course_id
	INNER JOIN lesson ON chapter.id = lesson.chapter_id
	GROUP BY course.id, chapter.id
	ORDER BY course.id
	LIMIT 10 OFFSET 0;

-- Course and Chapter and Lesson with number of student being finished or still progressing the lessons
-- TODO

-- Other
SELECT * FROM admin;
SELECT * FROM student;
SELECT * FROM teacher;
SELECT * FROM course;
SELECT * FROM chapter;
SELECT * FROM lesson;
SELECT * FROM student_course;
SELECT * FROM student_course_lesson;