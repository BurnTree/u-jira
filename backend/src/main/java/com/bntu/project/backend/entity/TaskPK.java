package com.bntu.project.backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TaskPK implements Serializable {

    @Column(name = "task_id")
    private int taskId;
    @Column(name = "project")
    private int project;

    public TaskPK() {
    }

    public TaskPK(int taskId, int project) {
        this.taskId = taskId;
        this.project = project;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskPK taskPK = (TaskPK) o;
        return taskId == taskPK.taskId &&
                project == taskPK.project;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, project);
    }
}
