package com.bntu.project.backend.controller;

import com.bntu.project.backend.dto.AuthDto;
import com.bntu.project.backend.helpers.Role;
import com.bntu.project.backend.service.StudentService;
import com.bntu.project.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private TeacherService teacherService;
    private StudentService studentService;

    @Autowired
    public AuthController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity authentication(@RequestParam(name = "role") String role, @RequestBody AuthDto authData) {
        if (role.equalsIgnoreCase(Role.TEACHER))
            return ResponseEntity.ok(teacherService.auth(authData));
        else if (role.equalsIgnoreCase(Role.STUDENT)) {
            return ResponseEntity.ok(studentService.auth(authData));
        }
        return ResponseEntity.badRequest().build();
    }
}
