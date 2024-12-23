package com.votingEsystem.controllers;


import com.votingEsystem.Entities.User;
import com.votingEsystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get/users")
    List<User> getAllUsers(){
        return userService.getAllUsers();

    }

    @PostMapping("add/user")
    void addUser(@RequestBody User user)
    {
        userService.addUser(user);

    }
}
