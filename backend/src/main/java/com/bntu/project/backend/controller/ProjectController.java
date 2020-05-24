package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Project;
import com.bntu.project.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/all")
    public List<Project> getAll() {
        return projectService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Project> findById(@PathVariable int id) {
        return projectService.findById(id);
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Project> update(@RequestBody Project project) {
        return new ResponseEntity<>(projectService.update(project), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Project> add(@RequestBody Project project) {
        return new ResponseEntity<>(projectService.add(project), HttpStatus.OK);
    }
}
