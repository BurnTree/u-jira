package com.bntu.project.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group_subject_ref")
public class GroupSubjectRef {
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "band")
    private Band band;
    @ManyToOne
    @JoinColumn(name = "subject")
    private Subject subject;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Band getBand() {
        return band;
    }
    public void setBand(Band band) {
        this.band = band;
    }

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupSubjectRef that = (GroupSubjectRef) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
