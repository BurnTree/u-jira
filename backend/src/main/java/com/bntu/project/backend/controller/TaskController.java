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
@RequestMapping("/api/project/{projectId}/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll(@PathVariable int projectId) {
        return taskService.findAll(projectId);
    }

    @GetMapping(value = "/{taskId}")
    public Optional<Task> findById(@PathVariable int projectId, @PathVariable int taskId) {
        return taskService.findById(taskId, projectId);
    }
//    @PutMapping(value = "/put")
//    public ResponseEntity<Task> update(@RequestBody Task task) {
//        return new ResponseEntity<>(taskService.update(task), HttpStatus.OK);
//    }

    @PostMapping(value = "/add")
    public ResponseEntity<Task> add(@PathVariable int projectId, @RequestBody Task task) {
        return new ResponseEntity<>(taskService.add(projectId, task), HttpStatus.OK);
    }

//    @DeleteMapping(value = "/delete")
//    public ResponseEntity<String> delete(@RequestParam(name = "id") int id) {
//        taskService.delete(id);
//        return new ResponseEntity<>("Delete success", HttpStatus.OK);
//    }
}
