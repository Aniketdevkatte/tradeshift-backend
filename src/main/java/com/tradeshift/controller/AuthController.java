
package com.tradeshift.controller;

import com.tradeshift.config.JwtUtil;
import com.tradeshift.model.User;
import com.tradeshift.repository.UserRepository;
import com.tradeshift.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired private UserService userService;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UserRepository userRepository;

    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody User user){
        Map<String,Object> resp = new HashMap<>();
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            resp.put("error","username_taken");
            return resp;
        }
        User saved = userService.register(user);
        resp.put("user", saved);
        return resp;
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody User user){
        Optional<User> db = userRepository.findByUsername(user.getUsername());
        Map<String,String> resp = new HashMap<>();
        if(db.isPresent() && passwordEncoder.matches(user.getPassword(), db.get().getPassword())){
            String token = jwtUtil.generateToken(user.getUsername());
            resp.put("token", token);
            return resp;
        } else {
            resp.put("error", "invalid_credentials");
            return resp;
        }
    }
}
