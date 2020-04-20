package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.entity.Teacher;
import com.bntu.project.backend.repositories.TeacherRepository;
import com.bntu.project.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepo;

    @Override
    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public Optional<Teacher> findById(int id) {
        return teacherRepo.findById(id);
    }

    @Override
    public Teacher update(Teacher upTeacher) {
        return teacherRepo.save(upTeacher);
    }

    @Override
    public Teacher add(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public void delete(int id) {
        teacherRepo.deleteById(id);
    }

}
