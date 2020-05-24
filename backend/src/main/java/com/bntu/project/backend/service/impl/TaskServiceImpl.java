package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.entity.Task;
import com.bntu.project.backend.entity.TaskPK;
import com.bntu.project.backend.entity.TaskStatus;
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
    public List<Task> findAll(int projectId) {
        return taskRepo.findAllById_Project(projectId);
    }

    @Override
    public Optional<Task> findById(int taskId, int project) {
        TaskPK id = new TaskPK(taskId, project);
        return taskRepo.findById(id);
    }

    @Override
    public Task update(Task upTask) {
        return taskRepo.save(upTask);
    }

    @Override
    public Task add(int projectId, Task task) {
        int newId = taskRepo.lastTaskInProject(projectId) + 1;
        task.setId(new TaskPK(newId, projectId));
        task.setStatus(new TaskStatus(1));
        Task afterTask = taskRepo.save(task);
        return afterTask;
    }

    @Override
    public void delete(int taskId, int project) {
        TaskPK id = new TaskPK(taskId, project);
        taskRepo.deleteById(id);
    }
}
