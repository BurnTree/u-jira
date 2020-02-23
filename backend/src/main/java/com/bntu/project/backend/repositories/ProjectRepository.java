package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllByStudent(int id);
    Project findProjectByStudentAndTeacher(int idStudent, int idTeacher);
}
