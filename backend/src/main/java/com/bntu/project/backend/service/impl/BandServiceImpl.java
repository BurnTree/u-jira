package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.entity.Band;
import com.bntu.project.backend.repositories.BandRepository;
import com.bntu.project.backend.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandServiceImpl implements BandService {

    @Autowired
    private BandRepository bandRepository;

    @Override
    public List<Band> getByParam(String column, String value) {
        return bandRepository.getBandByParams(column, value);
    }

    @Override
    public List<Band> getAll() {
        return bandRepository.findAll();
    }
}
