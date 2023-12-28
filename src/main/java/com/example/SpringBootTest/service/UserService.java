package com.example.SpringBootTest.service;

import com.example.SpringBootTest.model.User;

public interface UserService {
    User addUser(User user);

    User findUserByUsername(String username);
}
