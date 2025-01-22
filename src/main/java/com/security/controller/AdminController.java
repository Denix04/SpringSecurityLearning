package com.security.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.security.entity.User;
import com.security.service.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String admin() {
        return "hello admins";
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> create_user(@Validated @RequestBody User user) {
        System.out.println(user);
        try {
            userService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created");
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    
}
