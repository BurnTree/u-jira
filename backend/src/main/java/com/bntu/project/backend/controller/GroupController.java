package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Group;
import com.bntu.project.backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "/all")
    public List<Group> getAll() {
        return groupService.findAll();
    }

    @GetMapping(value = "/get")
    public Optional<Group> findById(@RequestParam(name = "id") int id) {
        return groupService.findById(id);
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Group> update(@RequestBody Group group) {
        return new ResponseEntity<>(groupService.update(group), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Group> add(@RequestBody Group group) {
        return new ResponseEntity<>(groupService.add(group), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "id") int id) {
        groupService.delete(id);
        return new ResponseEntity<>("Delete succes", HttpStatus.OK);
    }


    @GetMapping(value = "/teacher")
    public List<Group> findByStudent(@RequestParam(name = "id") int id) {
        return groupService.getAllByTeacher(id);
    }

}
