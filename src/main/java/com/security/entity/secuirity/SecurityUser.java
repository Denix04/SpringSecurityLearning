package com.security.entity.secuirity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.entity.User;

public class SecurityUser implements UserDetails{

    private final User user;

    public SecurityUser(User user) {
        this.user = user;
    }

	@Override
	public String getUsername() {
        return user.getUsername();
	}

	@Override
	public String getPassword() {
        return user.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
	}
}
