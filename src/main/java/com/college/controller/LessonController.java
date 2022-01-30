package com.college.controller;

import com.college.entity.Lesson;
import com.college.service.LessonService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.LESSON)
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/")
    public Lesson createLesson(Lesson lesson){
        return lessonService.createLesson(lesson);
    }

    @PutMapping("/")
    public Lesson updateLesson(Lesson lesson){
        return lessonService.updateLesson(lesson);
    }

    @GetMapping("/{id}")
   public Optional<Lesson> getLesson(@PathVariable ("id") Integer id){
        return lessonService.getLesson(id);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public List<Lesson> listLesson(){
        return lessonService.listLesson();
    }
}
