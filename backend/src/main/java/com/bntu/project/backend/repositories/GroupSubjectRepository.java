package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.GroupSubjectRef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupSubjectRepository extends JpaRepository<GroupSubjectRef, Integer> {
}
