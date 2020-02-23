package com.bntu.project.backend.service;

import com.bntu.project.backend.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAll();
    Optional<Teacher> findById(int id);
    Teacher update(Teacher upTeacher);
    Teacher add(Teacher teacher);
    void delete(int id);

    Optional<Teacher> auth(String login, String password);
}
