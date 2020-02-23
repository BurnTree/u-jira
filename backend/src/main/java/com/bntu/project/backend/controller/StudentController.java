package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Group;
import com.bntu.project.backend.entity.Student;
import com.bntu.project.backend.entity.Teacher;
import com.bntu.project.backend.repositories.StudentRepository;
import com.bntu.project.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/all")
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @GetMapping(value = "/get")
    public Optional<Student> findById(@RequestParam(name = "id") int id){
        return studentService.findById(id);
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Student> update(@RequestBody Student student){
        return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Student> add(@RequestBody Student student){
        return new ResponseEntity<>(studentService.add(student), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "id") int id){
        studentService.delete(id);
        return new ResponseEntity<>("Delete succes", HttpStatus.OK);
    }

    @GetMapping(value = "/auth")
    public ResponseEntity<Student> authentication(@RequestParam(name = "login") String login,
                                            @RequestParam(name = "pass") String password) {
        Optional<Student> response = studentService.auth(login, password);
        if(!response.isPresent()) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(response.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/teachers")
    public List<Teacher> findAllTeachersByStudent(@RequestParam(name = "id") int id){
        return studentService.findTeachersStudent(id);
    }

    @GetMapping(value = "/group")
    public List<Student> findByGroup(@RequestParam(name = "id") int id){
        return studentService.findStudentByGroup(id);
    }

    @GetMapping(value = "/sort")
    public List<Student> findByGroup(@RequestParam(name = "idTeacher") int idTeacher,
                                     @RequestParam(name = "idGroup") int idGroup){
        return studentService.getSortedStudent(idTeacher, idGroup);
    }
}
