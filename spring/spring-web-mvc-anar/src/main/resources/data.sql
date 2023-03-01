CREATE TABLE students (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name varchar(45),
  surname varchar(45),
  email varchar(45),
  phone varchar(45));
  
insert into students
 (name,surname,email,phone) values
('Medin','Seydayev','medin02@gmail.com','055-674-0976'),
('Elvin','Memmedov','memmedove0@gmail.com','077-543-7654'),
('Anar','Hummetov','anar22@gmail.com','055-519-0001');