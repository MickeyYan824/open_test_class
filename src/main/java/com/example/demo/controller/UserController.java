package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/userController")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "save")
    @Transactional
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping(value = "delete/{id}")
    @Transactional
    public String deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "SUCCESS";
    }

    @GetMapping(value = "findAll")
    public List<User> findAll() {
        return userService.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }


}
