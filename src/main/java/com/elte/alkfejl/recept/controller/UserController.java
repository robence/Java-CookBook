package com.elte.alkfejl.recept.controller;

import java.util.Optional;

import com.elte.alkfejl.recept.model.User;
import com.elte.alkfejl.recept.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        Optional<User> oUser = userRepository.findByUsername(user.getUsername());
        if (oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        user.setPassword(user.getPassword());
        user.setRole(User.Role.ROLE_USER);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        return ResponseEntity.ok().build();
    }
}
