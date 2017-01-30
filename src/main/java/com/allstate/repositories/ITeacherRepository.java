package com.allstate.repositories;

import com.allstate.Enums.Gender;
import com.allstate.entities.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITeacherRepository extends CrudRepository <Teacher,Integer> {

    String sql = "SELECT * FROM TEACHERS WHERE SEX=?1";
    @Query(value = sql, nativeQuery = true)
    public List<Teacher> findByGender(@Param("sex") String gender);

    String sql1 = "SELECT * FROM TEACHERS WHERE AGE>?1";
    @Query(value = sql1, nativeQuery = true)
    public  List<Teacher> findOlderThanAge(@Param("age") int age);
}
