package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.dto.AuthDto;
import com.bntu.project.backend.dto.UserDto;
import com.bntu.project.backend.entity.Student;
import com.bntu.project.backend.helpers.Role;
import com.bntu.project.backend.repositories.StudentRepository;
import com.bntu.project.backend.repositories.TaskRepository;
import com.bntu.project.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private TaskRepository taskRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public Student update(Student upStudent) {
        return studentRepo.save(upStudent);
    }

    @Override
    public Student add(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public UserDto auth(AuthDto authDto) {
        Student student = studentRepo.getByLoginAndPsw(authDto.getLogin(), authDto.getPsw());
        UserDto studDto = new UserDto();
        studDto.setId(student.getId());
        studDto.setName(student.getName());
        studDto.setRole(Role.STUDENT);
        return studDto;
    }
}
