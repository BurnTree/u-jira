package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.entity.Task;
import com.bntu.project.backend.repositories.StatusRepository;
import com.bntu.project.backend.repositories.TaskRepository;
import com.bntu.project.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    StatusRepository statusRepo;

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
        int idProject = task.getProject();
        if (permissionOnCreatedTask(idProject)) taskRepo.save(task);
        return null;
    }

    @Override
    public void delete(int id) {
        taskRepo.deleteById(id);
    }

    @Override
    public List<Task> findAllByProject(int projectId) {
        return taskRepo.findAllByProject(projectId);
    }

    @Override
    public String getStatusName(int idStatus) {
        return statusRepo.findById(idStatus).get().getName();
    }

    @Override
    public boolean permissionOnCreatedTask(int idProject) {
        List<Task> allTask = taskRepo.findAllByProject(idProject);
        List<Task> allCompleteTask = taskRepo.findAllByProjectAndStatus(idProject, 4);
        return allTask.size() == allCompleteTask.size();
    }

    @Override
    public float getKoefRate(int idTask) {
        DecimalFormat df = new DecimalFormat("0.00");
        Task task = taskRepo.findById(idTask).get();
        LocalDate created = task.getDataCreated().toLocalDate();
        LocalDate dedline = task.getDataDeadline().toLocalDate();
        LocalDate changed = task.getDataChanged().toLocalDate();
        Duration timeOnCompilte = Duration.between(created.atStartOfDay(), dedline.atStartOfDay());
        Duration timeChanged = Duration.between(created.atStartOfDay(), changed.atStartOfDay());
        return (float)timeChanged.toDays() / (float) timeOnCompilte.toDays();
    }
}
