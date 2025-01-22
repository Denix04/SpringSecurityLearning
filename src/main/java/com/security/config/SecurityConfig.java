package com.security.config;

import org.springframework.context.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
            authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers("/user/**").hasRole("USER")
                    .anyRequest().permitAll()
                    )
            .httpBasic(Customizer.withDefaults())
            .csrf(csrf -> {});

/* This is another for to configure the userDetailsService

        UserDetails user = new User.withUsername().password().roles()
                                    .build();

        http.userDetailsService(new InMemoryUserDetailsManager(user));
*/

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("user"))
            .roles("USER")
            .build();

        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("ADMIN")
            .build();

        UserDetails dev = User.builder()
            .username("dev")
            .password(passwordEncoder().encode("dev"))
            .roles("USER","ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user,admin,dev);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
