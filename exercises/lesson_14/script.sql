-- PostgreSQL

-- Q1 - Add 100 students

-- Q2
SELECT * FROM classes ;

-- Q3
SELECT COUNT(students.id) AS num_students FROM students ;

-- Q4
-- For classes
SELECT classes.id, classes.title AS class_title, SUM(students_classes.score) AS total_class_score 
	FROM classes 
	LEFT JOIN students_classes ON classes.id = students_classes.class_id
	GROUP BY classes.id
	ORDER BY classes.id;
-- For students
SELECT students.id, students.lastname, students.midname, students.firstname, SUM(students_classes.score) AS total_score 
	FROM students 
	LEFT JOIN students_classes ON students.id = students_classes.student_id
	GROUP BY students.id
	ORDER BY students.id;

-- Q5
-- For classes
SELECT classes.id, classes.title AS class_title, ROUND(AVG(students_classes.score), 2) AS avg_class_score 
	FROM classes 
	LEFT JOIN students_classes ON classes.id = students_classes.class_id
	GROUP BY classes.id
	ORDER BY classes.id;
-- For students
SELECT students.id, students.lastname, students.midname, students.firstname, ROUND(AVG(students_classes.score), 2) AS avg_score 
	FROM students 
	LEFT JOIN students_classes ON students.id = students_classes.student_id
	GROUP BY students.id
	ORDER BY students.id;

-- Q6
SELECT classes.id, classes.title AS class_title, MAX(students_classes.score) AS max_class_score 
	FROM classes 
	LEFT JOIN students_classes ON classes.id = students_classes.class_id
	GROUP BY classes.id
	ORDER BY classes.id;

-- Q7
SELECT classes.id, classes.title AS class_title, MIN(students_classes.score) AS min_class_score 
	FROM classes 
	LEFT JOIN students_classes ON classes.id = students_classes.class_id
	GROUP BY classes.id
	ORDER BY classes.id;

-- Q7
SELECT students.id, students.lastname, students.midname, students.firstname
	FROM students
	WHERE SUBSTRING(students.firstname, 1, 1) = 'A'
	ORDER BY students.id;

-- Q8
SELECT students.id, students.lastname, students.midname, students.firstname, classes.title AS class_title, students_classes.score AS class_score
	FROM students
	LEFT JOIN students_classes ON students.id = students_classes.student_id
	LEFT JOIN classes ON classes.id = students_classes.class_id
	WHERE classes.title = 'Math' AND (students_classes.score = 9 OR students_classes.score = 10)
	ORDER BY students.id;

-- Q9
SELECT students.id, students.lastname, students.midname, students.firstname, SUM(students_classes.score) AS total_class_score 
	FROM students 
	LEFT JOIN students_classes ON students.id = students_classes.student_id
	GROUP BY students.id
	ORDER BY total_class_score DESC;

-- Q10
SELECT students.id, students.lastname, students.midname, students.firstname, SUM(students_classes.score) AS total_class_score 
	FROM students 
	LEFT JOIN students_classes ON students.id = students_classes.student_id
	GROUP BY students.id
	ORDER BY total_class_score DESC
	LIMIT 5;

-- Q11
SELECT students.id, students.lastname, students.midname, students.firstname
	FROM students
	LEFT JOIN students_classes ON students.id = students_classes.student_id
	LEFT JOIN classes ON classes.id = students_classes.class_id
	WHERE (classes.title = 'Literature' AND students_classes.score >= 8) AND (classes.title = 'English' AND students_classes.score < 6)
	GROUP BY students.id
	ORDER BY students.id;

-- Q12
WITH
	temp_table1 AS (
		SELECT students.id, students.lastname, students.midname, students.firstname, SUM(students_classes.score) AS total_class_score 
			FROM students
			LEFT JOIN students_classes ON students.id = students_classes.student_id
			LEFT JOIN classes ON classes.id = students_classes.class_id
			GROUP BY students.id
			HAVING SUM(students_classes.score) < 10
			ORDER BY students.id
	)
-- SELECT * FROM temp_table1;
SELECT COALESCE(students.id, temp_table1.id) AS id, COALESCE(students.lastname, temp_table1.lastname) AS lastname, COALESCE(students.midname, temp_table1.midname) AS midname, COALESCE(students.firstname, temp_table1.firstname) AS firstname
	FROM students
	INNER JOIN students_classes ON students.id = students_classes.student_id AND students_classes.class_id = 1 AND students_classes.score < 5
	FULL OUTER JOIN temp_table1 ON students.id = temp_table1.id
	ORDER BY students.id;

-- Q13
-- Create a temp table to view the results
-- temp table contains students whose final scores are lower than 5 or have at least 1 subject score equals 0
CREATE TABLE students1 AS
	WITH
		temp_table1 AS (
			SELECT students.id, students.lastname, students.midname, students.firstname, ROUND(AVG(students_classes.score), 2) AS avg_class_score 
				FROM students
				LEFT JOIN students_classes ON students.id = students_classes.student_id
				LEFT JOIN classes ON classes.id = students_classes.class_id
				GROUP BY students.id
				HAVING AVG(students_classes.score) < 5
				ORDER BY students.id
		)
	-- SELECT * FROM temp_table1;
	SELECT COALESCE(students.id, temp_table1.id) AS id, COALESCE(students.lastname, temp_table1.lastname) AS lastname, COALESCE(students.midname, temp_table1.midname) AS midname, COALESCE(students.firstname, temp_table1.firstname) AS firstname
		FROM students
		INNER JOIN students_classes ON students.id = students_classes.student_id AND students_classes.score = 0
		FULL OUTER JOIN temp_table1 ON students.id = temp_table1.id
		ORDER BY students.id;
SELECT * FROM students1;

-- Actually update the students table
-- Excluding all students whose final scores are lower than 5 or have at least 1 subject score equals 0
WITH
	temp_table1 AS (
		SELECT students.id, students.lastname, students.midname, students.firstname, ROUND(AVG(students_classes.score), 2) AS avg_class_score 
			FROM students
			LEFT JOIN students_classes ON students.id = students_classes.student_id
			LEFT JOIN classes ON classes.id = students_classes.class_id
			GROUP BY students.id
			HAVING AVG(students_classes.score) < 5
			ORDER BY students.id
	)
UPDATE students
	SET	grade = CASE
		WHEN students.grade = 10 THEN 11
		WHEN students.grade = 11 THEN 12
		WHEN students.grade = 12 THEN 13
	END
	WHERE students.id NOT IN (SELECT COALESCE(students.id, temp_table1.id)
							   FROM students
							   INNER JOIN students_classes ON students.id = students_classes.student_id AND students_classes.score = 0
							   FULL OUTER JOIN temp_table1 ON students.id = temp_table1.id
							   ORDER BY students.id);