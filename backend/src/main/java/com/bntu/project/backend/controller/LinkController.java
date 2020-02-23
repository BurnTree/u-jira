package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Link;
import com.bntu.project.backend.repositories.LinkRepository;
import com.bntu.project.backend.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/link")
public class LinkController {

    private LinkService linkService;

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping(value = "/all")
    public List<Link> getAll() {
        return linkService.findAll();
    }

    @GetMapping(value = "/get")
    public Optional<Link> findById(@RequestParam(name = "id") int id){
        return linkService.findById(id);
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Link> update(@RequestBody Link link){
        return new ResponseEntity<>(linkService.update(link), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Link> add(@RequestBody Link link){
        return new ResponseEntity<>(linkService.add(link), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "id") int id){
        linkService.delete(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }

    @GetMapping(value = "/group")
    public List<Link> getSub(@RequestParam(name = "id") int id) {
        return linkRepository.findAllByGroup(id);
    }
}
