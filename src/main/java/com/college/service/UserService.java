package com.college.service;

import com.college.entity.User;
import com.college.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    Optional<User> getUser(Integer userId);
    List<User> listUser();
    Map<String,Object> getMostCourseAndVideoView() throws ResourceNotFoundException;

}
