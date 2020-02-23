package com.bntu.project.backend.service;

import com.bntu.project.backend.entity.Student;
import com.bntu.project.backend.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(int id);
    Student update(Student upStudent);
    Student add(Student student);
    void delete(int id);

    Optional<Student> auth(String login, String password);
    List<Teacher> findTeachersStudent(int id);
    List<Student> findStudentByGroup(int idGroup);
    List<Student> getSortedStudent(int idTeacher, int idGroup);
}
