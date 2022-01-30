package com.college.controller;

import com.college.entity.Course;
import com.college.entity.View;
import com.college.exception.ResourceNotFoundException;
import com.college.repo.ViewRepository;
import com.college.service.CourseService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.COURSE)
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public Course createCourse(Course course){
        return courseService.createCourse(course);
    }

    @PutMapping("/")
    public Course updateCourse(Course course){
        return courseService.updateCourse(course);
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourse(@PathVariable ("id") Integer id) throws ResourceNotFoundException {

        return courseService.getCourse(id);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public List<Course> listCourse(){
        return courseService.listCourse();
    }

    @GetMapping("/active/{subjectId}")
    public List<Course> findAllActiveCourseOrBySubject(@PathVariable ("subjectId") List<Integer> subjectIds) throws ResourceNotFoundException {
        return courseService.findAllActiveCourseBySubject(subjectIds);
    }

    @GetMapping("/active/{courseIds}")
    public List<Course> findSelectedCourseforAllActiveLessons(@PathVariable ("courseIds") List<Integer> courseIds) throws ResourceNotFoundException {
        return courseService.findSelectedCourseforAllActiveLessons(courseIds);
    }

    @PutMapping("/subscribe")
    public List<Course> subscribeCourse(List<Course> courses) throws ResourceNotFoundException {
        return courseService.subscribeCourse(courses);
    }
}
