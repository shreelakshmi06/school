
use schooltest;

set FOREIGN_KEY_CHECKS = 0;
truncate table students;
truncate table klasses;
truncate table teachers;
set FOREIGN_KEY_CHECKS = 1;

insert into students (email) values
  ('aaa@aol.com'),
  ('bbb@aol.com'),
  ('ccc@aol.com'),
  ('ddd@aol.com');

insert into teachers (name, age, gender) values
  ('chyld',70,'MALE'),
  ('shree',22,'FEMALE'),
  ('vinit',23,'MALE'),
  ('kavya',35,'FEMALE');

insert into klasses (credits, department, fee, name, semester, teacher_id) values
  (4, 'SCIENCE', 3000.00, 'sumit sir class', '2017-01-30 00:00:00', 1),
  (3, 'ENGINEERING', 9120.00, 'chyld sir class', '2017-01-20 00:00:00', 2),
  (2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00', 2);
