package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Teacher;
import com.bntu.project.backend.repositories.TeacherRepository;
import com.bntu.project.backend.service.TaskService;
import com.bntu.project.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/get")
    public Optional<Teacher> findById(@RequestParam(name = "id") int id){
        return teacherService.findById(id);
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Teacher> update(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.update(teacher), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Teacher> add(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.add(teacher), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "id") int id){
        teacherService.delete(id);
        return new ResponseEntity<>("Delete succes", HttpStatus.OK);
    }

    @GetMapping(value = "/auth")
    public ResponseEntity<Teacher> authentication(@RequestParam(name = "login") String login,
                                                  @RequestParam(name = "pass") String password) {
        Optional<Teacher> response = teacherService.auth(login, password);
        if(!response.isPresent()) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(response.get(), HttpStatus.OK);
    }
}
