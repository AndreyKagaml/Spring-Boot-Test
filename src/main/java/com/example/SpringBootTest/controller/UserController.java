package com.example.SpringBootTest.controller;

import com.example.SpringBootTest.dto.AuthenticationResponse;
import com.example.SpringBootTest.dto.UserRequest;
import com.example.SpringBootTest.dto.UserResponse;
import com.example.SpringBootTest.model.User;
import com.example.SpringBootTest.security.UserDetailsImpl;
import com.example.SpringBootTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.example.SpringBootTest.security.JwtUtil;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    @Autowired
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

//    @GetMapping()
//    public List<UserResponse> getAll() {
//        return userService.getAll().stream()
//                .map(UserResponse::new)
//                .toList();
//    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse save(@RequestBody User user) {
        return new UserResponse(userService.addUser(user));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody UserRequest userRequest) {
        User user = userService.findUserByUsername(userRequest.getUsername());
        if (user == null || !user.getPassword().equals(userRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        final UserDetails userDetails = new UserDetailsImpl(user);
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
