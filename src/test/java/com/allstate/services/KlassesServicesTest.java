package com.allstate.services;

import com.allstate.Enums.Department;
import com.allstate.entities.Klasses;
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

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateKlass() throws Exception {
        Klasses klass = new Klasses();
        klass.setName("abc");
        klass.setDepartment(Department.SCIENCE);
        klass.setFee((float)12.23);
        klass.setCredits(12);
        klass.setSemester(now());
        Klasses after = this.klassService.create(klass);
        assertEquals("abc",after.getName());
        assertEquals(3,after.getId());
        assertEquals(0,after.getVersion());
        assertEquals((float)12.23,after.getFee(),0.1);
    }

    @Test
    public void shouldFindById() throws Exception{
        Klasses result = this.klassService.findById(2);
        assertNotNull(result);
    }
}