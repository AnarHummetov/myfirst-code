 
 insert into courses
 (name,phone,address,enabled) values
 ('Zeka','012-435-8736','Nizami rayonu',true),
 ('Xemse','099-536-7676','Yasamal rayonu',true),
 ('Ugur','066-534-5334','Xetai rayonu',false);

insert into admins 
(name,surname,email,phone,birthday) values
('Elcin','Memmedov','memmedov03@gmail.com','033-977-9898','1996-06-16'),
('Ibrahim','Seferov','ibo073@gmail.com','034-676-9898','1991-03-07'),
('Murad','Eliyev','eliyevm@gmail.com','035-985-9898','1994-10-12');

insert into managers 
(name,surname,email,phone,birthday) values
('Deyanet','Memmedov','memmedovd91@gmail.com','033-977-9898','1980-06-16'),
('Sabir','Ibadov','ibads0@gmail.com','034-676-9898','1990-03-07'),
('Vasif','Eynullayev','eyev00@gmail.com','035-985-9898','1992-10-12');
 
insert into students 
(name,surname,email,phone,birthday,address) values
('Zakir','Asirli','asirlizakir@gmail.com','033-999-9898','1990-05-06','Xetai r.'),
('Huseyn','Ceferov','bisquisemasuta@gmail.com','034-999-9898','1990-02-07','Nizami r.'),
('Faiq','Haciyev','faiqhajiyev77@gmail.com','035-999-9898','1990-11-12','Nesimi r.');

insert into teachers 
(name,surname,email,phone,birthday) values
('Azer','Melikli','melikov89@gmail.com','033-999-9898','1989-04-06'),
('Huseyn','Ceferov','bisquisemasuta@gmail.com','034-999-9898','1987-03-07'),
('Natiq','Aliyev','faiqhajiyev77@gmail.com','035-999-9898','2004-10-12');

insert into parents 
(name,surname,email,phone,birthday) values
('Mehmet','Adilli','adilmehmet@gmail.com','033-999-9999','1973-05-06'),
('Namiq','Ferecov','ferecov88@gmail.com','034-999-9898','1988-02-07'),
('Amil','Nebiyev','amilnebiyev@gmail.com','035-999-9898','1980-11-12');

insert into groups 
(group_name,training_category,training, lesson_day_hour) values
('Java qrupu','programlasdirma','java','1-4'),
('Avtomatika qrupu','elektronika','ardinuo','3-6'),
('UI/UX qrupu','dizayn','ui','2-5');


insert into users 
(username, password) values
('Azer','{noop}123'),
('Murad','{noop}1234'),
('Vasif','{noop}11'),
('Zakir','{noop}12');

insert into authorities
(username,authority) values
('Murad','admin'),
('Vasif','manager'),
('Azer','teacher'),
('Zakir','student');


--insert into groups_students  
--(teacher_group_id, student_id) values
--('Azer','{noop}123'),
--('Zakir','{noop}12');
