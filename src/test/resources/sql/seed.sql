use schooltest;

TRUNCATE TABLE students;
TRUNCATE TABLE klasses;
TRUNCATE TABLE teachers;

INSERT INTO klasses (name,semester,credits,department,fee) VALUES
  ('sumit sir class','2017-01-30', 2,'SCIENCE',3000.00 ),
  ('chyld sir class','2017-01-20', 4,'ENGINEERING',9120.00 );

INSERT INTO teachers(name,age,sex) VALUES
  ('chyld',70,'MALE'),
  ('shree',22,'FEMALE'),
  ('VINIT',23,'MALE'),
  ('KAVYA',35,'FEMALE');