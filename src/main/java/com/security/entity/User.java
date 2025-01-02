package com.security.entity;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String userName;
    private String password;
    private LinkedList<Authoritie> authorities;


	@Override
	public String getUsername() {
        return userName;
	}

	@Override
	public String getPassword() {
        return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
	}
}
