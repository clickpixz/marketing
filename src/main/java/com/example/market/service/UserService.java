package com.example.market.service;

import com.example.market.entity.User;
import com.example.market.security.UserPrincipal;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    Optional<User> searchUser(Long id);
    List<User> findAll();
    void deleteUser(Long id);
    UserPrincipal findByUsername(String username);
}
