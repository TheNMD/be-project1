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

-- VALUES
INSERT INTO classes (title)
	VALUES ('Math');
INSERT INTO classes (title)
	VALUES ('Literature');
INSERT INTO classes (title)
	VALUES ('English');

INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Cong', 'Quan', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ho', 'Gia', 'Khoa', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Duc', 'Hieu', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Truong', 'Cong', 'Ai', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Vo', 'Bao', 'Hieu', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Phat', 'Hieu', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Phan', 'Minh', 'An', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ho', 'Gia', 'Dat', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Truong', 'Huy', 'Khang', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Trung', 'Quan', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ly', 'Trung', 'Tuyet', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ngo', 'Bach', 'Tai', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Dinh', 'Trung', 'Tai', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Tran', 'Duc', 'Dat', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Hoang', 'Dat', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Vo', 'Bao', 'Tai', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Duc', 'Anh', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Le', 'Gia', 'Tai', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Vo', 'Phat', 'Tam', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Vo', 'Phat', 'Kiet', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Tran', 'Duc', 'Binh', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ly', 'Van', 'An', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ly', 'Thi', 'Lien', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Trung', 'Khoa', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Truong', 'Phat', 'Tam', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ho', 'Duc', 'Tam', 17, 11);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Pham', 'Khoa', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Hoang', 'Phuc', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Phan', 'Hoang', 'Tuyet', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ly', 'Thi', 'Tam', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Truong', 'Duc', 'Hieu', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Gia', 'Tai', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Dinh', 'Bach', 'Quan', 17, 11);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Le', 'Dat', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Tran', 'Gia', 'Hieu', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ngo', 'Bao', 'Phuc', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Phan', 'Bao', 'Khang', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Dinh', 'Minh', 'Lien', 17, 11);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Ngo', 'Binh', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Vo', 'Huy', 'Tuyet', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Gia', 'Lien', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Phan', 'Duc', 'Binh', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Le', 'Bach', 'Phuc', 18, 12);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Ngo', 'An', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Huy', 'Quan', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Tran', 'Cong', 'Lien', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Tran', 'Khanh', 'Tai', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Minh', 'Hieu', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Huy', 'Dat', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Phan', 'Thi', 'Khang', 17, 11);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Dinh', 'Binh', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Le', 'Hoang', 'Kiet', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Dinh', 'Hoang', 'Khoa', 18, 12);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Dinh', 'Khang', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Gia', 'Tuyet', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Gia', 'Hieu', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Tran', 'Trung', 'Tai', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ly', 'Hoang', 'Lien', 17, 11);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Vo', 'Dat', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Duc', 'Anh', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Duc', 'Ai', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ho', 'Minh', 'Tam', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Truong', 'Trung', 'Binh', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Dinh', 'Cong', 'Tam', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ngo', 'Phat', 'Dat', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Minh', 'Tuyet', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ngo', 'Phat', 'Binh', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Dinh', 'Thi', 'An', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ngo', 'Duc', 'An', 16, 10);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Pham', 'Tai', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Le', 'Minh', 'Tam', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Duc', 'Khoa', 16, 10);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Le', 'Binh', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Dinh', 'Bach', 'Kiet', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ho', 'Thi', 'Kiet', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ly', 'Cong', 'An', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ho', 'Gia', 'Tuyet', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Duc', 'An', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Tran', 'Cong', 'Kiet', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Dinh', 'Thi', 'An', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Truong', 'Minh', 'Khoa', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Le', 'Duc', 'Tam', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ngo', 'Cong', 'Hieu', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Truong', 'Gia', 'Phuc', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Tran', 'Hoang', 'Binh', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Truong', 'Gia', 'Kiet', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Phan', 'Trung', 'Binh', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ngo', 'Cong', 'Tam', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Pham', 'Bao', 'Ai', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Dinh', 'Duc', 'An', 18, 12);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Tran', 'Khang', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ly', 'Minh', 'Khang', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Tran', 'Bach', 'Tai', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ngo', 'Gia', 'Anh', 18, 12);
INSERT INTO students (lastname, firstname, age, grade)
	VALUES ('Truong', 'Quan', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Ngo', 'Bao', 'Khoa', 18, 12);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Le', 'Bach', 'Phuc', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Phan', 'Gia', 'Tuyet', 17, 11);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Phan', 'Bao', 'Phuc', 16, 10);
INSERT INTO students (lastname, midname, firstname, age, grade)
	VALUES ('Nguyen', 'Van', 'Khoa', 17, 11);

INSERT INTO students_classes (student_id, class_id, score)
	VALUES (1, 1, 3.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (1, 2, 8.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (1, 3, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (2, 1, 10.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (2, 2, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (2, 3, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (3, 1, 2.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (3, 2, 3.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (3, 3, 1.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (4, 1, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (4, 2, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (4, 3, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (5, 1, 5.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (5, 2, 5.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (5, 3, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (6, 1, 5.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (6, 2, 2.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (6, 3, 9.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (7, 1, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (7, 2, 6.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (7, 3, 7.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (8, 1, 1.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (8, 2, 0.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (8, 3, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (9, 1, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (9, 2, 5.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (9, 3, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (10, 1, 6.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (10, 2, 2.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (10, 3, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (11, 1, 2.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (11, 2, 6.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (11, 3, 1.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (12, 1, 5.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (12, 2, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (12, 3, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (13, 1, 2.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (13, 2, 5.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (13, 3, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (14, 1, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (14, 2, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (14, 3, 0.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (15, 1, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (15, 2, 2.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (15, 3, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (16, 1, 3.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (16, 2, 9.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (16, 3, 5.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (17, 1, 0.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (17, 2, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (17, 3, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (18, 1, 6.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (18, 2, 0.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (18, 3, 5.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (19, 1, 8.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (19, 2, 7.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (19, 3, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (20, 1, 9.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (20, 2, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (20, 3, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (21, 1, 6.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (21, 2, 5.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (21, 3, 7.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (22, 1, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (22, 2, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (22, 3, 0.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (23, 1, 5.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (23, 2, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (23, 3, 0.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (24, 1, 9.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (24, 2, 7.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (24, 3, 5.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (25, 1, 5.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (25, 2, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (25, 3, 0.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (26, 1, 9.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (26, 2, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (26, 3, 1.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (27, 1, 0.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (27, 2, 8.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (27, 3, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (28, 1, 4.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (28, 2, 3.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (28, 3, 8.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (29, 1, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (29, 2, 1.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (29, 3, 3.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (30, 1, 6.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (30, 2, 5.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (30, 3, 8.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (31, 1, 9.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (31, 2, 1.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (31, 3, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (32, 1, 0.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (32, 2, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (32, 3, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (33, 1, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (33, 2, 2.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (33, 3, 5.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (34, 1, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (34, 2, 4.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (34, 3, 1.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (35, 1, 3.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (35, 2, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (35, 3, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (36, 1, 9.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (36, 2, 3.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (36, 3, 8.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (37, 1, 3.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (37, 2, 10.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (37, 3, 0.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (38, 1, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (38, 2, 5.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (38, 3, 6.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (39, 1, 5.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (39, 2, 6.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (39, 3, 0.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (40, 1, 3.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (40, 2, 2.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (40, 3, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (41, 1, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (41, 2, 9.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (41, 3, 0.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (42, 1, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (42, 2, 9.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (42, 3, 8.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (43, 1, 2.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (43, 2, 1.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (43, 3, 2.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (44, 1, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (44, 2, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (44, 3, 2.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (45, 1, 8.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (45, 2, 1.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (45, 3, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (46, 1, 2.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (46, 2, 0.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (46, 3, 4.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (47, 1, 1.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (47, 2, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (47, 3, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (48, 1, 10.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (48, 2, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (48, 3, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (49, 1, 5.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (49, 2, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (49, 3, 1.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (50, 1, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (50, 2, 0.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (50, 3, 5.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (51, 1, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (51, 2, 1.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (51, 3, 7.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (52, 1, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (52, 2, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (52, 3, 2.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (53, 1, 2.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (53, 2, 8.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (53, 3, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (54, 1, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (54, 2, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (54, 3, 3.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (55, 1, 1.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (55, 2, 9.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (55, 3, 4.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (56, 1, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (56, 2, 6.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (56, 3, 8.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (57, 1, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (57, 2, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (57, 3, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (58, 1, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (58, 2, 2.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (58, 3, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (59, 1, 6.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (59, 2, 0.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (59, 3, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (60, 1, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (60, 2, 1.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (60, 3, 3.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (61, 1, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (61, 2, 1.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (61, 3, 7.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (62, 1, 6.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (62, 2, 5.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (62, 3, 6.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (63, 1, 1.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (63, 2, 5.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (63, 3, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (64, 1, 5.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (64, 2, 3.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (64, 3, 2.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (65, 1, 6.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (65, 2, 1.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (65, 3, 9.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (66, 1, 10.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (66, 2, 5.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (66, 3, 4.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (67, 1, 1.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (67, 2, 2.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (67, 3, 3.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (68, 1, 6.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (68, 2, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (68, 3, 4.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (69, 1, 8.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (69, 2, 1.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (69, 3, 7.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (70, 1, 9.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (70, 2, 6.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (70, 3, 1.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (71, 1, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (71, 2, 6.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (71, 3, 2.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (72, 1, 2.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (72, 2, 6.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (72, 3, 0.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (73, 1, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (73, 2, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (73, 3, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (74, 1, 2.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (74, 2, 8.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (74, 3, 2.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (75, 1, 4.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (75, 2, 3.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (75, 3, 10.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (76, 1, 1.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (76, 2, 5.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (76, 3, 0.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (77, 1, 3.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (77, 2, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (77, 3, 2.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (78, 1, 10.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (78, 2, 8.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (78, 3, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (79, 1, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (79, 2, 2.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (79, 3, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (80, 1, 2.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (80, 2, 2.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (80, 3, 10.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (81, 1, 2.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (81, 2, 1.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (81, 3, 1.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (82, 1, 8.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (82, 2, 0.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (82, 3, 8.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (83, 1, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (83, 2, 6.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (83, 3, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (84, 1, 8.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (84, 2, 5.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (84, 3, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (85, 1, 9.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (85, 2, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (85, 3, 1.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (86, 1, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (86, 2, 1.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (86, 3, 1.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (87, 1, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (87, 2, 7.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (87, 3, 0.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (88, 1, 1.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (88, 2, 3.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (88, 3, 5.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (89, 1, 0.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (89, 2, 1.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (89, 3, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (90, 1, 8.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (90, 2, 7.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (90, 3, 6.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (91, 1, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (91, 2, 3.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (91, 3, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (92, 1, 7.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (92, 2, 1.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (92, 3, 4.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (93, 1, 7.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (93, 2, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (93, 3, 5.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (94, 1, 8.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (94, 2, 5.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (94, 3, 1.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (95, 1, 10.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (95, 2, 4.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (95, 3, 4.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (96, 1, 2.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (96, 2, 1.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (96, 3, 8.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (97, 1, 6.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (97, 2, 7.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (97, 3, 5.75);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (98, 1, 3.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (98, 2, 7.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (98, 3, 9.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (99, 1, 6.25);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (99, 2, 4.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (99, 3, 0.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (100, 1, 5.5);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (100, 2, 2.0);
INSERT INTO students_classes (student_id, class_id, score)
	VALUES (100, 3, 3.75);

-- SELECT
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
	WHERE (classes.title = 'Literature' AND students_classes.score >= 8) OR (classes.title = 'English' AND students_classes.score < 6)
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


-- Other
SELECT * FROM students ORDER BY students.id;
SELECT * FROM classes ORDER BY classes.id;
SELECT * FROM students_classes ORDER BY students_classes.student_id;

DROP TABLE students CASCADE;
DROP TABLE classes CASCADE;
DROP TABLE students_classes CASCADE;