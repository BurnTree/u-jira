package com.bntu.project.backend.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Project {
    private int id;
    private String name;
    private String description;
    private Date deadline;
    private int student;
    private int teacher;
    private int status;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "deadline", nullable = true)
    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "student", nullable = true)
    public int getStudent() {
        return student;
    }
    public void setStudent(int student) {
        this.student = student;
    }

    @Basic
    @Column(name = "teacher", nullable = true)
    public int getTeacher() {
        return teacher;
    }
    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "status_project", nullable = true)
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                Objects.equals(name, project.name) &&
                Objects.equals(description, project.description) &&
                Objects.equals(deadline, project.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, deadline);
    }
}
