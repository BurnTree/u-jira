package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Band;
import com.bntu.project.backend.entity.Project;
import com.bntu.project.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/global")
public class GlobalController {

    private SubjectService subjectService;
    private ProjectService projectService;
    private TaskService taskService;
    private TeacherService teacherService;
    private BandService bandService;

    @Autowired
    public GlobalController(SubjectService subjectService,
                            ProjectService projectService,
                            TaskService taskService,
                            TeacherService teacherService,
                            BandService bandService) {
        this.subjectService = subjectService;
        this.projectService = projectService;
        this.taskService = taskService;
        this.teacherService = teacherService;
        this.bandService = bandService;
    }

    @GetMapping(value = "/get")
    public ResponseEntity getSubjectByParam(@RequestParam String column, @RequestParam String value) {
        List<Band> ba = bandService.getByParam(column, value);
        return ResponseEntity.ok(ba);
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAll() {
        List<Band> ba = bandService.getAll();
        return ResponseEntity.ok(ba);
    }

    @GetMapping(value = "/getByStudent")
    public ResponseEntity getByStudent(@RequestParam int studentId) {
        List<Project> response = projectService.getAllByStudent(studentId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getByStudentAndTeacher")
    public ResponseEntity getByStudent(@RequestParam int studentId, @RequestParam int teacherId) {
        List<Project> response = projectService.getByStudentAndTeacher(studentId, teacherId);
        return ResponseEntity.ok(response);
    }
}
