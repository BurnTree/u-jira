package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.StatusProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusProjectRepository extends JpaRepository<StatusProject, Integer> {
}
