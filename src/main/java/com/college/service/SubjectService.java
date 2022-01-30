package com.college.service;

import com.college.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    Subject createSubject(Subject subject);
    Subject updateSubject(Subject subject);
    Optional<Subject> getSubject(Integer subjectId);
    List<Subject> listSubject();
}
