package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreate() throws Exception {
        Student student = new Student();
        student.setEmail("abc@gmail.com");
        Student after = this.studentService.create(student);
        assertEquals(5, after.getId());
        assertEquals(0, after.getVersion());
        assertEquals("abc@gmail.com", after.getEmail());
    }

    @Test
    public void shouldFIndById() throws Exception {
        Student student = new Student();
        student.setEmail("pqr@gmail.com");
        Student after = this.studentService.create(student);
        Student result = this.studentService.findById(5);
        assertEquals("pqr@gmail.com", result.getEmail());
    }

    @Test
    public void shouldFIndByEmail() throws Exception {
        Student student = new Student();
        student.setEmail("xyz@gmail.com");
        Student after = this.studentService.create(student);
        Student result = this.studentService.findByEmail("xyz@gmail.com");
        assertEquals(5, result.getId());
    }


}