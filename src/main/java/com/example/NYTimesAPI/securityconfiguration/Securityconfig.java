package com.example.NYTimesAPI.securityconfiguration;

import com.example.NYTimesAPI.customauthenticationentrypoint.CustomAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Securityconfig {

    @Autowired
    private CustomAuthentication auth;

    @SuppressWarnings("deprecation")
    @Bean
    public InMemoryUserDetailsManager getUserDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder().username("test").password("test")
                .roles("admin").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/g").authenticated()
                ).formLogin().and()
                .httpBasic().authenticationEntryPoint(auth);
        return http.build();
    }


}
