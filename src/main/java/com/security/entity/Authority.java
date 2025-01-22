package com.security.entity;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Authority implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String authoritie;

    public Authority(String authoritie) {
        this.authoritie = authoritie;
    }

	@Override
	public String getAuthority() {
        return authoritie;
	}
}
