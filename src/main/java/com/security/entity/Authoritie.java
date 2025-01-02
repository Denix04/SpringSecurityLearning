package com.security.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authoritie implements GrantedAuthority{
    private String authoritie;

    public Authoritie(String authoritie) {
        this.authoritie = authoritie;
    }

	@Override
	public String getAuthority() {
        return authoritie;
	}
}
