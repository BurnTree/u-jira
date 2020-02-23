package com.bntu.project.backend.service;

import com.bntu.project.backend.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    List<Group> findAll();
    Optional<Group> findById(int id);
    Group update(Group upGroup);
    Group add(Group group);
    void delete(int id);

    List<Group> getAllByTeacher(int id);
}
