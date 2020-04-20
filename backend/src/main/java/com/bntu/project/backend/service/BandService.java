package com.bntu.project.backend.service;

import com.bntu.project.backend.entity.Band;

import java.util.List;

public interface BandService {
    List<Band> getByParam(String column, String value);
    List<Band> getAll();
}
