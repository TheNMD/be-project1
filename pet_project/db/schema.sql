-- PostgreSQL

-- Table for Admin Users
CREATE TABLE admin
(
    id           BIGSERIAL PRIMARY KEY,
    status       VARCHAR(50) NOT NULL,
    username     VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NULL
);

-- Table for Students
CREATE TABLE student
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    status       VARCHAR(50) NOT NULL,
    age          INT NULL,
    username     VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NULL
);

-- Table for Teachers
CREATE TABLE teacher
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    status       VARCHAR(50) NOT NULL,
    username     VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NULL
);

-- Table for Courses
CREATE TABLE course
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(1000) NULL,
    status       VARCHAR(50) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NULL,
    teacher_id   BIGINT,
    FOREIGN KEY (teacher_id) REFERENCES teacher (id) ON DELETE CASCADE
);

-- Table for Chapters
CREATE TABLE chapter
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(1000) NULL,
    status       VARCHAR(50) NOT NULL,
    "order"      INT NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NULL,
    course_id    BIGINT,
    FOREIGN KEY (course_id) REFERENCES course (id) ON DELETE CASCADE
);

-- Table for Lessons
CREATE TABLE lesson
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(1000) NULL,
    status       VARCHAR(50) NOT NULL,
    type         VARCHAR(50) NOT NULL,
    url          VARCHAR(50) NULL,
    "order"      INT NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NULL,
    chapter_id   BIGINT,
    FOREIGN KEY (chapter_id) REFERENCES chapter (id) ON DELETE CASCADE
);

-- Relationship Table for Student-Course
CREATE TABLE student_course
(
    student_id   BIGINT,
    course_id    BIGINT,
    rating       INT NULL,
    review       VARCHAR(5000) NULL,
    status       VARCHAR(50) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NULL,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES course (id) ON DELETE CASCADE
);

-- Relationship Table for Student-Course-Lesson
CREATE TABLE student_course_lesson
(
    user_course_user_id   BIGINT,
    user_course_course_id BIGINT,
    lesson_id             BIGINT,
    status                VARCHAR(50) NOT NULL,
    created_date          TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_date          TIMESTAMP NULL,
    PRIMARY KEY (user_course_user_id, user_course_course_id, lesson_id),
    FOREIGN KEY (user_course_user_id, user_course_course_id) REFERENCES student_course (student_id, course_id) ON DELETE CASCADE,
    FOREIGN KEY (lesson_id) REFERENCES lesson (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS admin CASCADE;
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS teacher CASCADE;
DROP TABLE IF EXISTS course CASCADE;
DROP TABLE IF EXISTS chapter CASCADE;
DROP TABLE IF EXISTS lesson CASCADE;
DROP TABLE IF EXISTS student_course CASCADE;
DROP TABLE IF EXISTS student_course_lesson CASCADE;