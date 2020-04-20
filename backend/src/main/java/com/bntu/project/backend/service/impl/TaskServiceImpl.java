package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.entity.Task;
import com.bntu.project.backend.repositories.TaskRepository;
import com.bntu.project.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepo;


    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public Optional<Task> findById(int id) {
        return taskRepo.findById(id);
    }

    @Override
    public Task update(Task upTask) {
        return taskRepo.save(upTask);
    }

    @Override
    public Task add(Task task) {
        return null;
    }

    @Override
    public void delete(int id) {
        taskRepo.deleteById(id);
    }
}
