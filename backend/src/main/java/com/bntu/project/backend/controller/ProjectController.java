package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Project;
import com.bntu.project.backend.repositories.ProjectRepository;
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

    @GetMapping(value = "/get")
    public Optional<Project> findById(@RequestParam(name = "id") int id) {
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

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "id") int id) {
        projectService.delete(id);
        return new ResponseEntity<>("Delete succes", HttpStatus.OK);
    }

    @GetMapping(value = "/student")
    public List<Project> findByStudent(@RequestParam(name = "id") int id) {
        return projectService.getAllByStudent(id);
    }

    @GetMapping(value = "/projectBetweenStudentAndTeacher")
    public Project findByStudetnAndTeacher(@RequestParam(name = "idStudent") int idStudent,
                                                 @RequestParam(name = "idTeacher") int idTeacher) {
        return projectService.getProjectByStudetnAndTeacher(idStudent, idTeacher);
    }

    @GetMapping(value = "/status")
    public String getStatus(@RequestParam(name = "id") int id) {
        return projectService.getStatusName(id);
    }

    @GetMapping(value = "/rating")
    public float getRating(@RequestParam(name = "id") int id) {
        return projectService.getRatingProject(id);
    }

}
