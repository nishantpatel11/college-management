package com.college.controller;

import com.college.entity.Lesson;
import com.college.service.LessonService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.LESSON)
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/")
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson){
        return new ResponseEntity<Lesson> (lessonService.createLesson(lesson), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson lesson){
        return new ResponseEntity<Lesson> (lessonService.updateLesson(lesson), HttpStatus.OK);
    }

    @GetMapping("/{id}")
   public ResponseEntity<Optional<Lesson>> getLesson(@PathVariable ("id") Integer id){
        return new ResponseEntity<Optional<Lesson>> (lessonService.getLesson(id), HttpStatus.OK);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public ResponseEntity<List<Lesson>> listLesson(){
        return new ResponseEntity<List<Lesson>> (lessonService.listLesson(), HttpStatus.OK);
    }
}
