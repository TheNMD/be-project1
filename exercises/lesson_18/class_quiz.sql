SET search_path TO pet_project;

-- Class Quiz 1
SELECT teacher.id AS teacher_id, COUNT(course.id) AS course_count
	FROM teacher 
	LEFT JOIN course ON teacher.id = course.teacher_id
	GROUP BY teacher.id
	ORDER BY teacher.id;

-- Class Quiz 2
SELECT teacher.id AS teacher_id, teacher.name AS teacher_name, COUNT(course.id) AS course_count
	FROM teacher 
	LEFT JOIN course ON teacher.id = course.teacher_id
	GROUP BY teacher.id
	ORDER BY teacher.id;

-- Class Quiz 3
SELECT teacher.id AS teacher_id, teacher.name AS teacher_name, COUNT(course.id) AS course_count
	FROM teacher 
	LEFT JOIN course ON teacher.id = course.teacher_id
	GROUP BY teacher.id
	ORDER BY teacher.id
	LIMIT 2 OFFSET 2;

-- Class Quiz 4
SELECT teacher.id AS teacher_id, teacher.name AS teacher_name, COUNT(course.id) AS course_count
	FROM teacher 
	LEFT JOIN course ON teacher.id = course.teacher_id
	GROUP BY teacher.id
	ORDER BY teacher.id;

-- Class Quiz 5
SELECT student.id AS student_id, student.name AS student_name, course.name AS course_name
	FROM student 
	INNER JOIN student_course ON student.id = student_course.student_id
	INNER JOIN course ON course.id = student_course.course_id
	ORDER BY student.id;

-- Class Quiz 6
SELECT course.id AS course_id, course.name AS course_name, ROUND(AVG(student_course.rating), 2) AS average_rating
	FROM course 
	INNER JOIN student_course ON course.id = student_course.course_id
	GROUP BY course.id
	HAVING AVG(student_course.rating) >= 4
	ORDER BY course.id;

-- Class Quiz 7
SELECT student.id AS student_id, student.name AS student_name, course.name AS course_name, teacher.name AS teacher_name
	FROM student 
	INNER JOIN student_course ON student.id = student_course.student_id
	INNER JOIN course ON course.id = student_course.course_id
	INNER JOIN teacher ON teacher.id = course.teacher_id
	ORDER BY student.id;

-- Class Quiz 8
SELECT course.id AS course_id, course.name AS course_name, chapter.id AS chapter_id, chapter.name AS chapter_name, lesson.id AS lesson_id, lesson.name AS lesson_name, user_course_user_id, chapter.status AS status, student.name AS name 
	FROM course 
	INNER JOIN chapter ON course.id = chapter.course_id
	INNER JOIN lesson ON chapter.id = lesson.chapter_id
	INNER JOIN student_course ON course.id = student_course.course_id
	INNER JOIN student ON student.id = student_course.student_id
	INNER JOIN student_course_lesson ON student_course.student_id = student_course_lesson.user_course_user_id AND student_course.course_id = student_course_lesson.user_course_course_id AND lesson.id = student_course_lesson.lesson_id
	ORDER BY student_course_lesson.user_course_course_id, course.id, chapter.id, lesson.id;

-- Câu hỏi
SELECT * FROM student_course_lesson ORDER BY user_course_user_id, user_course_course_id, lesson_id;
-- User ID 1 đăng ký lớp ID 1 và lớp ID 2
-- User ID 1 học Lesson ID 2 ở Course ID 1 và Lesson ID 3 Course ID 2 (1)

SELECT id, name, course_id FROM chapter;
-- Chapter ID 1, 2, 3 lần lượt thuộc về Course ID 1, 2, 3
SELECT id, name, chapter_id FROM lesson;
-- Lesson ID 1, 2, 3 lần lượt thuộc về Chapter ID 1, 2, 3
-- => Course ID 1 chỉ có Lesson ID 1; Course ID 2 chỉ có Lesson ID 2; Course ID 3 chỉ có Lesson ID 3
-- => Trái với (1)

-- Class Quiz 9
WITH
	temp_table AS
	(
		SELECT
			student_course_lesson.lesson_id,
		    SUM(CASE WHEN student_course_lesson.status = 'not_started' THEN 1 ELSE 0 END) AS num_NotStarted,
		    SUM(CASE WHEN student_course_lesson.status = 'in_progress' THEN 1 ELSE 0 END) AS num_InProgress,
		    SUM(CASE WHEN student_course_lesson.status = 'completed' THEN 1 ELSE 0 END) AS num_Completed
			FROM student_course_lesson
			GROUP BY student_course_lesson.lesson_id
			ORDER BY student_course_lesson.lesson_id
	)
SELECT course.id AS course_id, course.name AS course_name, 
	   chapter.id AS chapter_id, chapter.name AS chapter_name, 
	   lesson.id AS lesson_id, lesson.name AS lesson_name, 
	   temp_table.num_completed AS completed_users, temp_table.num_inprogress AS in_progress_users
	FROM course
	INNER JOIN chapter ON course.id = chapter.course_id
	INNER JOIN lesson ON chapter.id = lesson.chapter_id
	INNER JOIN temp_table ON lesson.id = temp_table.lesson_id
	ORDER BY course.id, chapter.id, lesson.id;