package com.allstate.services;

import com.allstate.entities.Student;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private IStudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student){
        return this.studentRepository.save(student);
    }

    public Student findById(int id){
        return this.studentRepository.findOne(id);
    }

//    public List<Student> findAll(){
//        return this.studentRepository.findAll();
//    }

    public Student findByEmail(String email){
        return this.studentRepository.findByEmail(email);
    }
}
