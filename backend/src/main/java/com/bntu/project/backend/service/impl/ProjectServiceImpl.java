package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.entity.Project;
import com.bntu.project.backend.entity.Task;
import com.bntu.project.backend.repositories.ProjectRepository;
import com.bntu.project.backend.repositories.StatusProjectRepository;
import com.bntu.project.backend.repositories.TaskRepository;
import com.bntu.project.backend.service.ProjectService;
import com.bntu.project.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private StatusProjectRepository statusRepo;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepo;

    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    @Override
    public Optional<Project> findById(int id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project update(Project upProject) {
        return projectRepo.save(upProject);
    }

    @Override
    public Project add(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public void delete(int id) {
        projectRepo.deleteById(id);
    }

    @Override
    public List<Project> getAllByStudent(int id) {
        return projectRepo.findAllByStudent(id);
    }

    @Override
    public Project getProjectByStudetnAndTeacher(int idStudent, int idTeacher) {
        return projectRepo.findProjectByStudentAndTeacher(idStudent,idTeacher);
    }

    @Override
    public String getStatusName(int idStatus){
        return statusRepo.findById(idStatus).get().getName();
    }

    @Override
    public float getRatingProject(int idProject) {
        Task task = taskRepo.findByProjectAndStatus(idProject, 3);
        return taskService.getKoefRate(task.getId());
    }
}
