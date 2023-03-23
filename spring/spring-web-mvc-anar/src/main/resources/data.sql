CREATE TABLE students (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name varchar(45),
  surname varchar(45),
  email varchar(45),
  phone varchar(45),
  birthday date,
  sector varchar(45));
  
insert into students
 (name,surname,email,phone,birthday,sector) values
('Medin','Seydayev','medin02@gmail.com','055-674-0976','2000-05-03','Az'),
('Elvin','Memmedov','memmedove0@gmail.com','077-543-7654','1987-11-17','Ingilis'),
('Anar','Hummetov','anar22@gmail.com','055-519-0001','1999-06-17','Rus');