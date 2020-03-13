-- noinspection SqlNoDataSourceInspectionForFile

drop table if exists man;
drop table if exists company;
drop table if exists woman;
drop table if exists child;
drop table if exists tel;

create table man
(
    man_id        bigint(20) not null,
    name      varchar(30),
    lao_po_id bigint(20) not null,
    company_id bigint(20) not null
);


create table company
(
    company_id        bigint(20) not null,
    name      varchar(30)
);



create table woman
(
    woman_id          bigint(20) not null,
    name        varchar(30),
    lao_gong_id bigint(20) not null
);

create table child
(
    child_id         bigint(20) not null,
    name       varchar(30),
    lao_han_id bigint(20) not null,
    lao_ma_id bigint(20) not null
);


create table tel
(
    id         bigint(20) not null,
    tel       varchar(30),
    man_id bigint(20) not null
);

create table course
(
    course_id         bigint(20) not null,
    name       varchar(30)
);


create table student_course
(
    id         bigint(20) not null,
    student_id      bigint(20) not null,
    course_id      bigint(20) not null
);