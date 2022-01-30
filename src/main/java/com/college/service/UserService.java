package com.college.service;

import com.college.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    Optional<User> getUser(Integer userId);
    List<User> listUser();
}
