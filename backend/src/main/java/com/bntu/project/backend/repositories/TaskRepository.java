package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByProject(int project);
    List<Task> findAllByProjectAndStatus(int projectId, int stausId);
    Task findByProjectAndStatus(int idProject, int idStatus);
}
