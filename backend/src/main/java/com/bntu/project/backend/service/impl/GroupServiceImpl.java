package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.entity.Group;
import com.bntu.project.backend.entity.Link;
import com.bntu.project.backend.repositories.GroupRepository;
import com.bntu.project.backend.repositories.LinkRepository;
import com.bntu.project.backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepo;

    @Autowired
    private LinkRepository linkRepo;

    @Override
    public List<Group> findAll() {
        return groupRepo.findAll();
    }

    @Override
    public Optional<Group> findById(int id) {
        return groupRepo.findById(id);
    }

    @Override
    public Group update(Group upGroup) {
        return groupRepo.save(upGroup);
    }

    @Override
    public Group add(Group group) {
        return groupRepo.save(group);
    }

    @Override
    public void delete(int id) {
        groupRepo.deleteById(id);
    }

    @Override
    public List<Group> getAllByTeacher(int id) {
        List<Link> allGroupOwnTeacher = linkRepo.findAllByTeacher(id);
        List<Group> groups = new ArrayList<>();
        for(Link link: allGroupOwnTeacher){
            int idGroup = link.getGroup();
            Group group = groupRepo.findById(idGroup).get();
            groups.add(group);
        }
        return groups;
    }
}
