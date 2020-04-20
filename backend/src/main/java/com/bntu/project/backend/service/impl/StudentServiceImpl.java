package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.entity.*;
import com.bntu.project.backend.repositories.StudentRepository;
import com.bntu.project.backend.repositories.TaskRepository;
import com.bntu.project.backend.repositories.TeacherRepository;
import com.bntu.project.backend.service.ProjectService;
import com.bntu.project.backend.service.StudentService;
import com.bntu.project.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private TeacherRepository teacherRepo;


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



//    class SortByRating implements Comparator<Student> {
//        int idTeacher;
//
//        public SortByRating(int idTeacher) {
//            this.idTeacher = idTeacher;
//        }
//
//        public int compare(Student a, Student b) {
//            Project projectA = projectService.getProjectByStudetnAndTeacher(a.getId(), idTeacher);
//            Task taskA = taskRepo.findByProjectAndStatus(projectA.getId(), 3);
//            float koefA = taskService.getKoefRate(taskA.getId());
//
//            Project projectB = projectService.getProjectByStudetnAndTeacher(b.getId(), idTeacher);
//            Task taskB = taskRepo.findByProjectAndStatus(projectB.getId(), 3);
//            float koefB = taskService.getKoefRate(taskB.getId());
//            System.out.println("koef: " + koefA + " and " + koefB);
//            return (koefB < koefA)?1:-1;
//        }
//    }
//
//    @Override
//    public List<Student> getSortedStudent(int idTeacher, int idGroup) {
//        List<Student> students = studentRepo.findAllByGroup(idGroup);
//        students.removeIf((student) -> {
//            Project project = projectService.getProjectByStudetnAndTeacher(student.getId(), idTeacher);
//            Task task = taskRepo.findByProjectAndStatus(project.getId(), 3);
//            return task == null;
//        });
//        Collections.sort(students, new SortByRating(idTeacher));
//        return students;
//    }
}
