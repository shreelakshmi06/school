package com.allstate.services;

import com.allstate.Enums.Gender;
import com.allstate.entities.Teacher;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private ITeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher create(Teacher teacher1){
        return this.teacherRepository.save(teacher1);
    }

    public Teacher findById(int id){
        return this.teacherRepository.findOne(id);
    }

    public List<Teacher> findByGender(Gender gender){
        return this.teacherRepository.findByGender(gender);
    }

    public List<Teacher> findOlderThanAge(int age){
        return this.teacherRepository.findByAgeGreaterThan(age);
    }

    public Teacher findByName(String name){
        return this.teacherRepository.findByName(name);
    }
}
