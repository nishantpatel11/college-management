package com.college.service.impl;

import com.college.entity.Course;
import com.college.entity.User;
import com.college.entity.Video;
import com.college.exception.ResourceNotFoundException;
import com.college.repo.CourseRepository;
import com.college.repo.UserRepository;
import com.college.repo.VideoRepository;
import com.college.service.CourseService;
import com.college.service.UserService;
import com.college.utils.CourseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private VideoRepository videoRepository;

    private static Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public Map<String, Object> getMostCourseAndVideoView() throws ResourceNotFoundException {
       Video video = videoRepository.findMaxViewsOfVideos();
       Course course = courseRepository.findMaxViewsOfCourses();
       Map<String,Object> object = new HashMap<>();
       if(video != null || course != null) {
           object.put(CourseType.COURSE.name(), course.getName());
           object.put(CourseType.VIDEO.name(), video.getTitle());
           return object;
       }
       throw new ResourceNotFoundException("Resource not Found");
    }
}
