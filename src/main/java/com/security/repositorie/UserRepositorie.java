package com.security.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.User;

public interface UserRepositorie extends JpaRepository<User,Long> {
    
}
