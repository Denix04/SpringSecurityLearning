package com.security.entity;

import java.util.*;
import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.*;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String username;
    private String password;

    @OneToMany
    private Collection<Authority> authorities;

    public User(String name, String pw) {
        this.username = name;
        this.password = pw;
        this.authorities = new LinkedList<Authority>();
    }

    public User(String name, String pw, Collection<Authority> auth) {
        this.username = name;
        this.password = pw;
        this.authorities = auth;
    }

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
