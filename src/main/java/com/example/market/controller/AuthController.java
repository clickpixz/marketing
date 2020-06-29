package com.example.market.controller;

import  com.example.market.entity.Token;
import  com.example.market.entity.User;
import com.example.market.message.APIErrorResponse;
import com.example.market.message.APIResponse;
import com.example.market.message.APISuccReponse;
import  com.example.market.security.JwtUtil;
import  com.example.market.security.UserPrincipal;
import  com.example.market.service.TokenService;
import  com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    @PostAuthorize("hasAnyAuthority('ADMIN','MOD')")
    public APIResponse register(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setStatus(1);
        UserPrincipal user1=userService.findByUsername(user.getUsername());
        System.out.println(user1.getUsername());
        if (user1.getUsername()!=null) {
            return new APIErrorResponse().withMessage("tài khoản đã trùng");
        }
        userService.createUser(user);
        return new APISuccReponse().emptyBody().withMessage("Success");
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('ADMIN','MOD')")
    public APIResponse updateUser(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setStatus(1);
        userService.updateUser(user);
        return new APISuccReponse().emptyBody().withMessage("Success");
    }

    @PostMapping("/searchUser/{id}")
    @PostAuthorize("hasAnyAuthority('ADMIN','MOD')")
    public APIResponse searchUser(@RequestBody @PathVariable("id") Long id) {
        Optional<User> user=userService.searchUser(id);
        return new APISuccReponse().withBody(user).withMessage("Success");
    }

    @GetMapping("/getAllUser")
    @PreAuthorize("hasAnyAuthority('ADMIN','MOD')")
    public APIResponse getAllUser() {
        return new APISuccReponse().withBody( userService.findAll()).withMessage("Success");
    }

    @DeleteMapping ("/deleteUser/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MOD')")
    public APIResponse deleteUser(@RequestBody @PathVariable(name="id") Long id) {
        userService.deleteUser(id);
        return new APISuccReponse().emptyBody().withMessage("Success");
    }

    @PostMapping("/login")
    public APIResponse login(@RequestBody User user) {
        UserPrincipal userPrincipal = userService.findByUsername(user.getUsername());
        if (null == user || !new BCryptPasswordEncoder().matches(user.getPassword(), userPrincipal.getPassword())) {
            return new APIErrorResponse().withMessage("tài khoản hoặc mật khẩu không chính xác");
        }
        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));
        token.setTokenexpdate(jwtUtil.generateExpirationDate());
        tokenService.createToken(token);
        return new APISuccReponse().withMessage(token.getToken());
    }

//    @PostMapping("/logout")
//    public APIResponse logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return new APISuccReponse().emptyBody();
//    }

    @GetMapping("/hello")
    public ResponseEntity hello() {

        return ResponseEntity.ok("hello");
    }
}
