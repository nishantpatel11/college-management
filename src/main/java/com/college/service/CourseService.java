package com.college.service;

import com.college.entity.Course;
import com.college.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course createCourse(Course course);
    Course updateCourse(Course course);
    Optional<Course> getCourse(Integer courseId) throws ResourceNotFoundException;
    List<Course> listCourse();
    List<Course> findAllActiveCourseBySubject(List<Integer> subjectIds) throws ResourceNotFoundException;
    List<Course> subscribeCourse(List<Course> course) throws ResourceNotFoundException;
    List<Course> findSelectedCourseforAllActiveLessons(List<Integer> courseIds) throws ResourceNotFoundException;
}
