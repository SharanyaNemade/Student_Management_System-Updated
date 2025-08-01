package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.AbstractSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // Simple in‑memory admin account
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();
        
        
        UserDetails user = User.withDefaultPasswordEncoder()
        		.username("user")
        		.password("user123")
        		.roles("USER")
        		.build();
        
        return new InMemoryUserDetailsManager(admin);
    }

 

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Public URLs
                .requestMatchers("/", "/students", "/swagger-ui/**", "/v3/api-docs/**", "/error").permitAll()
                // Everything else needs login
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login") // custom login endpoint (will show default page if no login.html)
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
}
