package com.bntu.project.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Link {

    private int id;
    private int group;
    private int teacher;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "group_id", nullable = false)
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }

    @Column(name = "teacher_id", nullable = false)
    public int getTeacher() {
        return teacher;
    }
    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return id == link.id &&
                group == link.group &&
                teacher == link.teacher;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, teacher);
    }
}
