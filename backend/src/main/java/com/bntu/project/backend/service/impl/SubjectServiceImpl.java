package com.bntu.project.backend.service.impl;

import com.bntu.project.backend.repositories.SubjectRepository;
import com.bntu.project.backend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
}
