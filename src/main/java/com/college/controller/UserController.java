package com.college.controller;

import com.college.entity.User;
import com.college.exception.ResourceNotFoundException;
import com.college.repo.UserRepository;
import com.college.service.UserService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.USER)
public class UserController {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    UserController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.createUser(user),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity <User> updateUser(@RequestBody User user){
        return new ResponseEntity <User>(userService.updateUser(user),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable ("id") Long id){
        return new ResponseEntity<Optional<User>>  (userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public ResponseEntity<List<User>> listUser(){
        return new ResponseEntity<List<User>>(userService.listUser(),HttpStatus.OK);
    }


    public ResponseEntity<Map<String,Object>> getMostCourseAndVideoView(Principal principal) throws ResourceNotFoundException {
        List <User> users = userRepository.findByName(principal.getName());
        User user = users.isEmpty() ? null: users.get(0);
        if(user.getIsInstructor())
            return new ResponseEntity<Map<String,Object>>(userService.getMostCourseAndVideoView(), HttpStatus.OK);
        else
            throw new ResourceNotFoundException("Access Denied for given user");
    }
}
