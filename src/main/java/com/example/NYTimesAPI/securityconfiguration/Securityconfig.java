package com.example.NYTimesAPI.securityconfiguration;

import com.example.NYTimesAPI.customauthenticationentrypoint.CustomAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Securityconfig {


    @Autowired
    private CustomAuthentication auth;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @SuppressWarnings("deprecation")
    @Bean
    public UserDetailsService getUserDetailsManager() {
        UserDetails user = User.builder().username("foo").password(passwordEncoder.encode("foo")).build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return http
              .authorizeHttpRequests().requestMatchers("/NYTimes/topStories/**")
              .authenticated().and().httpBasic().and().formLogin().and().build();

    }


    }


