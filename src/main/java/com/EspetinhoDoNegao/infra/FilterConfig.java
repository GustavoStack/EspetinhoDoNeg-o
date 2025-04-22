package com.EspetinhoDoNegao.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class FilterConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and()
        .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST,"/products/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/products/**").permitAll()
                .requestMatchers("/orders/**").permitAll()
                .requestMatchers("/uploads/**").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
    }
}
