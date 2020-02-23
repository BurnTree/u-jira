package com.bntu.project.backend.controller;

import com.bntu.project.backend.entity.Attachment;
import com.bntu.project.backend.repositories.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentRepository attachmentRepo;

    @GetMapping(value = "/all")
    public List<Attachment> getAll() {
        return attachmentRepo.findAll();
    }

    @GetMapping(value = "/get")
    public Optional<Attachment> getById(@RequestParam(name = "id") int id) {
        return attachmentRepo.findById(id);
    }

    @GetMapping(value = "/task")
    public List<Attachment> getByTask(@RequestParam(name = "id") int id) {
        return attachmentRepo.findAllByTask(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Attachment> add(@RequestBody Attachment attachment) {
        return new ResponseEntity<>(attachmentRepo.save(attachment), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "id") int id) {
        attachmentRepo.deleteById(id);
        return new ResponseEntity<>("Delete succes", HttpStatus.OK);
    }

    @GetMapping(value = "/download")
    public ResponseEntity<Resource> downlandFile(@RequestParam(name = "id") int id) {
        ByteArrayResource resource = new ByteArrayResource(attachmentRepo.findById(id).get().getFile());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
