package com.example.SpringBootTest.security;



import com.example.SpringBootTest.model.User;
import com.example.SpringBootTest.repository.UserRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class SecurityUserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public SecurityUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        UserBuilder userBuilder = withUsername(user.getUsername());
        userBuilder.password(user.getPassword());

        return userBuilder.build();
    }
}
