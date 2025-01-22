package com.security;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.security.entity.Authority;
import com.security.entity.User;
import com.security.service.UserService;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);

        User user = new User("juan", "juan", List.of(new Authority("User")));
        UserService uService = new UserService();
        uService.create(user);
        System.out.println("hello world");
	}

}
