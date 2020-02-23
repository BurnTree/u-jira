package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByLogin(String login);
    List<Student> findAllByGroup(int idGroup);
}
