package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Iterable<Teacher> findByGender(String gender){
        return this.teacherRepository.findByGender(gender);
    }

    public Iterable<Teacher> findOlderThanAge(int age){
        return this.teacherRepository.findOlderThanAge(age);
    }
}
