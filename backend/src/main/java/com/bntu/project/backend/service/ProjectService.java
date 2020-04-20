package com.bntu.project.backend.service;

import com.bntu.project.backend.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAll();
    Optional<Project> findById(int id);
    Project update(Project upProject);
    Project add(Project project);
    void delete(int id);

    List<Project> getAllByStudent(int id);
    List<Project> getByStudentAndTeacher(int studentId, int teacherId);
    List<Project> getByTeacher(int teacherId);
//    float getRatingProject(int idProject);
}
