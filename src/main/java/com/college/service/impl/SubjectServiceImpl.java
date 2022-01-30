package com.college.service.impl;

import com.college.entity.Subject;
import com.college.repo.SubjectRepository;
import com.college.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    private static Logger logger =  LoggerFactory.getLogger(SubjectServiceImpl.class);


    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> getSubject(Integer subjectId) {
        return subjectRepository.findById(subjectId);
    }

    @Override
    public List<Subject> listSubject() {
        return subjectRepository.findAll();
    }
}
