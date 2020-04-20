package com.bntu.project.backend.service;

import com.bntu.project.backend.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();
    Optional<Task> findById(int id);
    Task update(Task upTask);
    Task add(Task task);
    void delete(int id);

//    float getKoefRate(int idTask);
}
