package com.bntu.project.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn (name = "band")
    private Band band;
    @Column(name = "login")
    private String login;
    @Column(name = "psw")
    private String psw;

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

    public Band getBand() {
        return band;
    }
    public void setBand(Band band) {
        this.band = band;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPsw() {
        return psw;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(band, student.band) &&
                Objects.equals(login, student.login) &&
                Objects.equals(psw, student.psw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
