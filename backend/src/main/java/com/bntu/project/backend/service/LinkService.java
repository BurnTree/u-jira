package com.bntu.project.backend.service;

import com.bntu.project.backend.entity.Link;

import java.util.List;
import java.util.Optional;

public interface LinkService {
    List<Link> findAll();
    Optional<Link> findById(int id);
    Link update(Link upLink);
    Link add(Link link);
    void delete(int id);
}
