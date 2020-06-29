package com.example.market.controller;

import com.example.market.entity.Role;
import com.example.market.entity.User;
import com.example.market.security.UserPrincipal;
import com.example.market.service.UserService;
import com.example.market.service.impl.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestController {
    public static void main(String[] args) {
        User user=new User();
        user.setUsername("ADMIN2");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setStatus(1);
        UserService userService=new UserServiceImpl();
        userService.createUser(user);
//
    }

}
