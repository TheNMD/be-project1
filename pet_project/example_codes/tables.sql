create table address
(
    id             bigint auto_increment
        primary key,
    country        varchar(255)                        not null,
    city           varchar(255)                        not null,
    district       varchar(255)                        null,
    street         varchar(255)                        null,
    address_detail varchar(255)                        null,
    created_date   timestamp default CURRENT_TIMESTAMP not null,
    updated_date   timestamp default CURRENT_TIMESTAMP null,
    status         varchar(255)                        null
);

create table admin
(
    id           bigint auto_increment
        primary key,
    status       varchar(50)                         not null,
    username     varchar(255)                        null,
    password     varchar(255)                        null,
    created_date timestamp default CURRENT_TIMESTAMP not null,
    updated_date timestamp                           null
);

create table teacher
(
    id           bigint auto_increment
        primary key,
    name         varchar(255)                        not null,
    status       varchar(50)                         not null,
    username     varchar(255)                        null,
    password     varchar(255)                        null,
    created_date timestamp default CURRENT_TIMESTAMP not null,
    updated_date timestamp                           null
);

create table course
(
    id           bigint auto_increment
        primary key,
    name         varchar(255)                        not null,
    description  varchar(1000)                       null,
    status       varchar(50)                         not null,
    created_date timestamp default CURRENT_TIMESTAMP not null,
    updated_date timestamp                           null,
    teacher_id   bigint                              null,
    constraint course_ibfk_1
        foreign key (teacher_id) references teacher (id)
);

create table chapter
(
    id           bigint auto_increment
        primary key,
    name         varchar(255)                        not null,
    description  varchar(1000)                       null,
    status       varchar(50)                         not null,
    `order`      int                                 not null,
    created_date timestamp default CURRENT_TIMESTAMP not null,
    updated_date timestamp                           null,
    course_id    bigint                              null,
    constraint chapter_ibfk_1
        foreign key (course_id) references course (id)
);

create index course_id
    on chapter (course_id);

create index teacher_id
    on course (teacher_id);

create table lesson
(
    id           bigint auto_increment
        primary key,
    name         varchar(255)                        not null,
    description  varchar(1000)                       null,
    status       varchar(50)                         not null,
    type         varchar(50)                         not null,
    url          varchar(50)                         null,
    `order`      int                                 not null,
    created_date timestamp default CURRENT_TIMESTAMP not null,
    updated_date timestamp                           null,
    chapter_id   bigint                              null,
    constraint lesson_ibfk_1
        foreign key (chapter_id) references chapter (id)
);

create index chapter_id
    on lesson (chapter_id);

create table user
(
    id           bigint auto_increment
        primary key,
    nickname     varchar(255)                        not null,
    status       varchar(50)                         not null,
    age          int                                 null,
    username     varchar(255)                        null,
    password     varchar(255)                        null,
    created_date timestamp default CURRENT_TIMESTAMP not null,
    updated_date timestamp                           null
);

create table full_name
(
    id           bigint auto_increment
        primary key,
    first_name   varchar(250)                        not null,
    mid_name     varchar(255)                        null,
    last_name    varchar(250)                        not null,
    status       varchar(50)                         null,
    created_date timestamp default CURRENT_TIMESTAMP null,
    updated_date timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    user_id      bigint                              null,
    constraint full_name_user_id_fk
        foreign key (user_id) references user (id)
);

create table user_address
(
    user_id    bigint not null,
    address_id bigint not null,
    primary key (user_id, address_id),
    constraint fk_address
        foreign key (address_id) references address (id),
    constraint fk_user
        foreign key (user_id) references user (id)
);

create table user_course
(
    user_id      bigint                              not null,
    course_id    bigint                              not null,
    rating       int                                 null,
    review       varchar(5000)                       null,
    status       varchar(50)                         not null,
    created_date timestamp default CURRENT_TIMESTAMP not null,
    updated_date timestamp                           null,
    primary key (user_id, course_id),
    constraint user_course_ibfk_1
        foreign key (user_id) references user (id),
    constraint user_course_ibfk_2
        foreign key (course_id) references course (id)
);

create index course_id
    on user_course (course_id);

create table user_course_lesson
(
    user_id      bigint                              not null,
    course_id    bigint                              not null,
    lesson_id    bigint                              not null,
    status       varchar(50)                         not null,
    created_date timestamp default CURRENT_TIMESTAMP not null,
    updated_date timestamp                           null,
    primary key (user_id, course_id, lesson_id),
    constraint user_course_lesson_ibfk_1
        foreign key (user_id, course_id) references user_course (user_id, course_id),
    constraint user_course_lesson_ibfk_2
        foreign key (lesson_id) references lesson (id)
);

create index lesson_id
    on user_course_lesson (lesson_id);