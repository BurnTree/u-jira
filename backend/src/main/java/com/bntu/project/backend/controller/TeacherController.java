package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Teacher;
import com.bntu.project.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = "/all")
    public List<Teacher> getAll() {
        return teacherService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Teacher> findById(@PathVariable int id){
        return teacherService.findById(id);
    }

//    @GetMapping(value = "/auth")
//    public ResponseEntity<Teacher> authentication(@RequestParam(name = "login") String login,
//                                                  @RequestParam(name = "pass") String password) {
//        Optional<Teacher> response = teacherService.auth(login, password);
//        if(!response.isPresent()) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
//        return new ResponseEntity<>(response.get(), HttpStatus.OK);
//    }
}
