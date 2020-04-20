package com.bntu.project.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "task_status")
public class TaskStatus {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private Integer name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }
    public void setName(Integer name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskStatus that = (TaskStatus) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
