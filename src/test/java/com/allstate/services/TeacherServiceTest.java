package com.allstate.services;

import com.allstate.Enums.Gender;
import com.allstate.entities.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = "/sql/seed.sql")
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCraeteTeacher() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setName("chyld");
        teacher.setAge(30);
        teacher.setSex(Gender.MALE);
        Teacher after = this.teacherService.create(teacher);
        assertEquals(5, after.getId());
        assertEquals("chyld", after.getName());
    }

    @Test
    public void findById() throws Exception {
        Teacher teacher1 = this.teacherService.findById(1);
        assertEquals(1, teacher1.getId());
        assertEquals("chyld", teacher1.getName());
        assertEquals(70,teacher1.getAge());
    }

    @Test
    public void shouldFindByGender() throws Exception {
        List<Teacher> teachers = (List) this.teacherService.findByGender("MALE");
        assertEquals(1, teachers.get(0).getId());
        assertEquals("chyld", teachers.get(0).getName());
        assertEquals(70,teachers.get(0).getAge());
    }

    @Test
    public void findOlderThanCertainAge() throws Exception {
        List<Teacher> teachers = (List) this.teacherService.findOlderThanAge(30);
        assertEquals(1, teachers.get(0).getId());
        assertEquals("chyld", teachers.get(0).getName());
        assertEquals(70,teachers.get(0).getAge());
    }
}