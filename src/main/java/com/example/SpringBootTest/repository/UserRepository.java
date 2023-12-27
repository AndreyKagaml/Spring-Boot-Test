package com.example.SpringBootTest.repository;

import com.example.SpringBootTest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findManagerByUsername(String username);
}