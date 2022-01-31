package com.college.controller;

import com.college.entity.Course;
import com.college.exception.ResourceNotFoundException;
import com.college.service.CourseService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.COURSE)
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(Course course){
        return new ResponseEntity<Course>(courseService.createCourse(course), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(Course course){
        return new ResponseEntity<Course>(courseService.updateCourse(course), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> getCourse(@PathVariable ("id") Integer id) throws ResourceNotFoundException {

        return new ResponseEntity<Optional<Course>> (courseService.getCourse(id), HttpStatus.OK);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public ResponseEntity<List<Course>> listCourse(){
        return new ResponseEntity<List<Course>> (courseService.listCourse(), HttpStatus.OK);
    }

    @PostMapping(ConstantsUtils.COURSE_ACTIVE_BY_SUBJECT)
    public ResponseEntity<List<Course>> findAllActiveCourseOrBySubject(@RequestBody List<Integer> subjectIds) throws ResourceNotFoundException {
        return new ResponseEntity<List<Course>> (courseService.findAllActiveCourseBySubject(subjectIds), HttpStatus.OK);
    }

    @GetMapping(ConstantsUtils.COURSE_ACTIVE_BY_LESSON)
    public ResponseEntity<List<Course>> findSelectedCourseforAllActiveLessons(@RequestBody List<Integer> courseIds) throws ResourceNotFoundException {
        return new ResponseEntity<List<Course>> (courseService.findSelectedCourseforAllActiveLessons(courseIds), HttpStatus.OK);
    }

    @PutMapping(ConstantsUtils.SUBSCRIBE_COURSE)
    public ResponseEntity<List<Course>> subscribeCourse(List<Course> courses) throws ResourceNotFoundException {
        return new ResponseEntity<List<Course>> (courseService.subscribeCourse(courses), HttpStatus.OK);
    }
}
