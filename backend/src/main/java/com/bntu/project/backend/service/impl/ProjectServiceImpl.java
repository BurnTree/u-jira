package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.dto.ProjectsStudentTableDto;
import com.bntu.project.backend.entity.Project;
import com.bntu.project.backend.repositories.ProjectRepository;
import com.bntu.project.backend.repositories.TaskRepository;
import com.bntu.project.backend.service.ProjectService;
import com.bntu.project.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

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
        return projectRepo.findAllByStudentId(id);
    }

    public List<Project> getByStudentAndTeacher(int studentId, int teacherId) {
        return projectRepo.findAllByStudentIdAndSubjectTeacherId(studentId, teacherId);
    }

    public List<Project> getByTeacher(int teacherId) {
        return projectRepo.findAllBySubjectTeacherId(teacherId);
    }

    @Override
    public List<ProjectsStudentTableDto> projectTableForStudent(int studentId) {
        List<ProjectsStudentTableDto> tableContent = new ArrayList<>();
        List<Project> projects = projectRepo.findAllByStudentId(studentId);
        for(Project project: projects){
            ProjectsStudentTableDto projectRow = new ProjectsStudentTableDto();
            projectRow.setId(project.getId());
            projectRow.setName(project.getName());
            projectRow.setTeacherName(project.getSubject().getTeacher().getName());
            projectRow.setSubject(project.getSubject().getName());
            projectRow.setCountTasks(taskRepo.getCountUnresolvedTasksInProject(project.getId()));
            tableContent.add(projectRow);
        }
        return tableContent;
    }
}
