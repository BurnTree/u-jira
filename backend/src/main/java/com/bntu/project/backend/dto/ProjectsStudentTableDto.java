package com.bntu.project.backend.dto;

public class ProjectsStudentTableDto {
    private int id;
    private String name;
    private String teacherName;
    private String subject;
    private int countTasks;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getCountTasks() {
        return countTasks;
    }
    public void setCountTasks(int countTasks) {
        this.countTasks = countTasks;
    }
}
