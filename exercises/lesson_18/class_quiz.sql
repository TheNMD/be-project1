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
	INNER JOIN student_course_lesson ON lesson.id = student_course_lesson.lesson_id
	INNER JOIN student_course ON student_course.course_id = student_course_lesson.user_course_course_id
	INNER JOIN student ON student.id = student_course_lesson.user_course_user_id
	ORDER BY course.id, user_course_user_id;