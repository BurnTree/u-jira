package com.bntu.project.backend.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;
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
    @Column(name = "description")
    private String description;
    @Column(name = "created")
    private Timestamp created;
    @Column(name = "deadline")
    private Timestamp deadline;
    @Column(name = "changed")
    private Timestamp changed;
    @Column(name = "comments")
    private String comments;

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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getDeadline() {
        return deadline;
    }
    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Timestamp getChanged() {
        return changed;
    }
    public void setChanged(Timestamp changed) {
        this.changed = changed;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
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
