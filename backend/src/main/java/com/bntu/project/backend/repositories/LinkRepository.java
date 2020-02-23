package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Link;
import com.bntu.project.backend.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link,Integer> {
    List<Link> findAllByGroup(int id);
    List<Link> findAllByTeacher(int id);
}
