package com.EspetinhoDoNegao.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class FilterConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/products/**").permitAll()
                .requestMatchers("/orders/**").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
    }
}
