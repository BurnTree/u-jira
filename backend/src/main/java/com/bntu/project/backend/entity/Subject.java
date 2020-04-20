package com.bntu.project.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private Integer year;
    @Column(name = "course")
    private Integer course;
    @ManyToOne
    @JoinColumn (name = "teacher")
    private Teacher teacher;

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

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCourse() {
        return course;
    }
    public void setCourse(Integer course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id &&
                Objects.equals(name, subject.name) &&
                Objects.equals(year, subject.year) &&
                Objects.equals(course, subject.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, course);
    }
}
