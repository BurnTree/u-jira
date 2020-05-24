package com.bntu.project.backend.service;

import com.bntu.project.backend.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll(int projectId);
    Optional<Task> findById(int taskId, int project);
    Task update(Task upTask);
    Task add(int projectId, Task task);
    void delete(int taskId, int project);

//    float getKoefRate(int idTask);
}
