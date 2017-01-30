package com.allstate.controllers;

import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public Teacher create(@RequestBody Teacher teacher){
        return this.teacherService.create(teacher);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public Teacher create(@PathVariable int id){
        return this.teacherService.findById(id);
    }

    @RequestMapping(value = {"/{gender}"}, method = RequestMethod.GET)
    public Iterable<Teacher> findByGender(String gender){
        return this.teacherService.findByGender(gender);
    }

    @RequestMapping(value = {"/{age}"}, method = RequestMethod.GET)
    public Iterable<Teacher> findOlderThanAge(int age){
        return this.teacherService.findOlderThanAge(age);
    }
}
