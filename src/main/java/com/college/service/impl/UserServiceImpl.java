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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

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
    public Optional<User> getUser(Long userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public Map<String, Object> getMostCourseAndVideoView() throws ResourceNotFoundException {
       List<Video> videos = videoRepository.findMaxViewsOfVideos();
       List<Course> courses = courseRepository.findMaxViewsOfCourses();
       Map<String,Object> object = new HashMap<>();
       if(!videos.isEmpty() || ! courses.isEmpty()) {
           object.put(CourseType.COURSE.name(), courses);
           object.put(CourseType.VIDEO.name(), videos);
           return object;
       }
       throw new ResourceNotFoundException("Resource not Found");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found: " + username));
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Arrays.asList(authority));
    }
    List<User> findByName(String name){
       return userRepository.findByName(name);
    }
}
