package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllByStudentId(int studentId);
    List<Project> findAllByStudentIdAndSubjectTeacherId(int studentId, int teacherId);
    List<Project> findAllBySubjectTeacherId(int teacherId);
}
