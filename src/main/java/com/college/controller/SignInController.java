package com.college.controller;

import com.college.entity.User;
import com.college.repo.UserRepository;
import com.college.utils.ConstantsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequestMapping("/signin")
public class SignInController {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public SignInController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public User signin(@RequestParam String email, @RequestParam String password) {
        User u = new User();
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        u.setRole(User.Role.USER);
        return repository.save(u);
    }

    @GetMapping
    public User healthCheck() {
        return new User();
    }

    @PostMapping("/validateEmail")
    public Boolean emailExists(@RequestParam String email) {
        return repository.existsByEmail(email);
    }
}
