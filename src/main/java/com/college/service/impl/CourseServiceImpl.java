package com.college.service.impl;

import com.college.entity.Course;
import com.college.entity.View;
import com.college.exception.ResourceNotFoundException;
import com.college.repo.CourseRepository;
import com.college.repo.ViewRepository;
import com.college.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ViewRepository viewRepository;
    private static Logger logger =  LoggerFactory.getLogger(CourseServiceImpl.class);


    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> getCourse(Integer courseId) throws ResourceNotFoundException {
        Optional<Course>  course = courseRepository.findById(courseId);
        if(!course.isEmpty()){
            viewRepository.save(new View("COURSE", LocalDateTime.now(),courseId));
            return course;
        }
        throw new ResourceNotFoundException(courseId + " doesn't exists");
    }

    @Override
    public List<Course> listCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findAllActiveCourseBySubject(List<Integer> subjectIds) throws ResourceNotFoundException {
        if(!subjectIds.isEmpty())
          return courseRepository.findAllActiveCourseBySubject(subjectIds);
        throw new ResourceNotFoundException("No resource found for update");

    }

    @Override
    public List<Course> subscribeCourse(List<Course> courses) throws ResourceNotFoundException {
        if(!courses.isEmpty())
            return courseRepository.saveAll(courses);
        throw new ResourceNotFoundException("No resource found for update");
    }

    @Override
    public List<Course> findSelectedCourseforAllActiveLessons(List<Integer> courseIds) throws ResourceNotFoundException {
        if(!courseIds.isEmpty())
         return courseRepository.findSelectedCourseforAllActiveLessons(courseIds);
        throw new ResourceNotFoundException("No resource found for update");

    }
}
