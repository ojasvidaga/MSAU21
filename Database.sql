use msau21;

create table employee (
emp_id bigint primary key auto_increment,
emp_email_id varchar
(100),
emp_name varchar
(50) not null,
emp_designation varchar
(30) not null,
emp_location varchar
(30) not null,
emp_img longblob,
last_modifier_id bigint,
last_modified_tm timestamp,
UNIQUE
(emp_email_id)
);

create table system_admin
(
    admin_id bigint primary key references employee(emp_id),
    last_modifier_id int null,
    last_modified_tm timestamp
);

create table trainer
(
    trainer_id bigint primary key references employee(emp_id),
    active_flag varchar(1),
    last_modifier_id int null,
    last_modified_tm timestamp
);

create table course (
course_id bigint primary key auto_increment,
course_description varchar
(100),
course_location varchar
(100),
course_name varchar
(100),
course_prerequisites varchar
(100),
course_skills varchar
(100),
course_admin_id bigint references system_admin
(admin_id),
last_modifier_id int null,
last_modified_tm timestamp,
course_active_flag varchar
(1)
);

create table training
(
    training_id bigint primary key auto_increment,
    course_id bigint references course(course_id),
    trainer_id bigint references trainer(trainer_id),
    training_feedback text(500) null,
    last_modifier_id int null,
    last_modified_tm timestamp,
    training_active_flag varchar(1)
);

create table training_material (
file_id bigint primary key auto_increment,
material_id bigint references training
(training_id),
material_file longblob not null,
material_file_name varchar
(100),
material_file_type varchar
(100),
active_flag varchar
(1),
last_modifier_id int null,
last_modified_tm timestamp,
uploaded_on timestamp,
deleted_on timestamp
);

insert into employee
values(1, 'omkar.ravindraraykar@accoliteindia.com', 'Omkar Raykar', 'Software Dev Intern', 'Mumbai', null, null, null);
insert into employee
values(2, 'darshan.sudhirpatil@accoliteindia.com', 'Darshan Patil', 'TDM', 'Bangalore', null, null, null);
insert into employee
values(3, 'radnyee.shailendramhatre@accoliteindia.com', 'Radnyee Mhatre', 'BU Head', 'Mumbai', null, null, null);
insert into employee
values(4, 'gaurav.mohinderyadav@accoliteindia.com', 'Gaurav Yadav', 'Software Dev Senior', 'Bangalore', null, null, null);
insert into employee
values(5, 'rohan.sanjaypawar@accoliteindia.com', 'Rohan Pawar', 'Software Dev Senior', 'Mumbai', null, null, null);

insert into system_admin
values(1, null, null);
insert into system_admin
values(2, null, null);

insert into trainer
values(2, 'Y', null, null);
insert into trainer
values(3, 'Y', null, null);
insert into trainer
values(4, 'Y', null, null);
insert into trainer
values(5, 'N', null, null);
