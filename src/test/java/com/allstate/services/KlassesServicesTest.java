package com.allstate.services;

import com.allstate.Enums.Department;
import com.allstate.entities.Klasses;
import com.allstate.entities.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

import static org.assertj.core.util.DateUtil.now;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = "/sql/seed.sql")
public class KlassesServicesTest {

    @Autowired
    private KlassesServices klassService;

    @Autowired
    private TeacherService teacherService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateKlass() throws Exception {
        Klasses klass = new Klasses();
        klass.setCredits(5);
        klass.setDepartment(Department.SCIENCE);
        klass.setFee((double) 12.23);
        klass.setName("abc");
        klass.setSemester(now());
        Teacher teacher = this.teacherService.findById(1);
        klass.setTeacher(teacher);
        Klasses after = this.klassService.create(klass);
        assertEquals("abc",after.getName());
        assertEquals(4,after.getId());
        assertEquals(0,after.getVersion());
        assertEquals((float)12.23,after.getFee(),0.1);
    }

    @Test
    public void shouldFindById() throws Exception{
        Klasses result = this.klassService.findById(2);
        assertNotNull(result);
    }
}
//
//    insert into klasses (credits, department, fee, name, semester, teacher_id) values
//  (4, 'SCIENCE', 3000.00, 'sumit sir class', '2017-01-30 00:00:00', 1),
//          (3, 'ENGINEERING', 9120.00, 'chyld sir class', '2017-01-20 00:00:00', 2),
//          (2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00', 2);