package com.college.controller;

import com.college.entity.Subject;
import com.college.service.SubjectService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.SUBJECT)
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/")
    public Subject createSubject(Subject subject){
        return subjectService.createSubject(subject);
    }

    @PutMapping("/")
    public Subject updateSubject(Subject subject){
        return subjectService.updateSubject(subject);
    }

    @GetMapping("/{id}")
   public Optional<Subject> getSubject(@PathVariable ("id") Integer id){
        return subjectService.getSubject(id);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public List<Subject> listSubject(){
        return subjectService.listSubject();
    }
}
