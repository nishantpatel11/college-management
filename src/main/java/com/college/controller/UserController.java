package com.college.controller;

import com.college.entity.User;
import com.college.service.UserService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.USER)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser(User user){
        return userService.createUser(user);
    }

    @PutMapping("/")
    public User updateUser(User user){
        return userService.updateUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable ("id") Integer id){
        return userService.getUser(id);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public List<User> listUser(){
        return userService.listUser();
    }
}
