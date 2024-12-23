package com.votingEsystem.Services;

import com.votingEsystem.Entities.User;
import com.votingEsystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
@Autowired
    UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findByName(String name){
        return userRepository.findByName(name).orElseThrow();


    }
}
