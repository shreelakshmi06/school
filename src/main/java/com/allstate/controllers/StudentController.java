package com.allstate.controllers;

import com.allstate.entities.Student;
import com.allstate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public Student create(@RequestBody Student student){
        return this.studentService.create(student);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Student> findAll(){
        return this.studentService.findAll();
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public Student findById(@PathVariable int id){
        return this.studentService.findById(id);
    }
}