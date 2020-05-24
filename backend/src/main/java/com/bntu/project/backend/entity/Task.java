package com.bntu.project.backend.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {


    @EmbeddedId
    private TaskPK id;

//    @ManyToOne
//    @JoinColumn(name = "project")
//    private Project project;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn (name = "status")
    @ColumnDefault("1")
    private TaskStatus status;

    public TaskPK getId() {
        return id;
    }
    public void setId(TaskPK id) {
        this.id = id;
    }

//    public Project getProject() {
//        return project;
//    }
//    public void setProject(Project project) {
//        this.project = project;
//    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
