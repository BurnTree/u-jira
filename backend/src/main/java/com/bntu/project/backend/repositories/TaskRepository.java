package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Task;
import com.bntu.project.backend.entity.TaskPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, TaskPK> {
    List<Task> findAllById_Project(int project);
    @Query(value = "SELECT task_id FROM task where project = :projectId order by task_id DESC LIMIT 1", nativeQuery = true)
    int lastTaskInProject(int projectId);
}
