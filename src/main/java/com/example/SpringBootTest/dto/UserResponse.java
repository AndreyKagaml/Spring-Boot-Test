package com.example.SpringBootTest.dto;

import com.example.SpringBootTest.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {
    Long id;
    String username;
    String password;

    public UserResponse(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
    }
}
