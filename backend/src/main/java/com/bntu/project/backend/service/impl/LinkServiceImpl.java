package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.entity.Link;
import com.bntu.project.backend.repositories.LinkRepository;
import com.bntu.project.backend.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepo;

    @Override
    public List<Link> findAll() {
        return linkRepo.findAll();
    }

    @Override
    public Optional<Link> findById(int id) {
        return linkRepo.findById(id);
    }

    @Override
    public Link update(Link upLink) {
        return linkRepo.save(upLink);
    }

    @Override
    public Link add(Link link) {
        return linkRepo.save(link);
    }

    @Override
    public void delete(int id) {
        linkRepo.deleteById(id);
    }
}
