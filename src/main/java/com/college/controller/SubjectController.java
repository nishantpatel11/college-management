package com.college.controller;

import com.college.entity.Course;
import com.college.entity.Subject;
import com.college.service.SubjectService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.SUBJECT)
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/")
    public ResponseEntity<Subject>  createSubject(@RequestBody Subject subject){
        return new ResponseEntity<Subject>  (subjectService.createSubject(subject), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
        return new ResponseEntity<Subject> (subjectService.updateSubject(subject), HttpStatus.OK);
    }

    @GetMapping("/{id}")
   public ResponseEntity<Optional<Subject>> getSubject(@PathVariable ("id") Integer id){
        return new ResponseEntity<Optional<Subject>> (subjectService.getSubject(id), HttpStatus.OK);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public ResponseEntity<List<Subject>> listSubject(){
        return new ResponseEntity<List<Subject>> (subjectService.listSubject(), HttpStatus.OK);
    }
}
