package com.teran.securitymethod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity()
@EnableGlobalMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {

    @Configuration
    static class SecurityAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/**").permitAll();
        }
    }

    @Bean
    UserDetailsService authentication() {
        UserDetails john = User.builder()
                .username("john@mail.com")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        UserDetails jack = User.builder()
                .username("jack@mail.com")
                .password(passwordEncoder().encode("StrongPassword"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(john, jack);
    }

    //PasswordEncoder needs for encode passwords
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
