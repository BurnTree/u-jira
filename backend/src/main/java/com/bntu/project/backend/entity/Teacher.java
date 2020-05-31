package com.bntu.project.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
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
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
