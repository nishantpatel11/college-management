package com.college.service;

import com.college.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonService {

    Lesson createLesson(Lesson lesson);
    Lesson updateLesson(Lesson lesson);
    Optional<Lesson> getLesson(Integer lessonId);
    List<Lesson> listLesson();
}
