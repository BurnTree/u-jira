package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Task;
import com.bntu.project.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/all")
    public List<Task> getAll() {
        return taskService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Task> findById(@PathVariable int id) {
        return taskService.findById(id);
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Task> update(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.update(task), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Task> add(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.add(task), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "id") int id) {
        taskService.delete(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }
}
