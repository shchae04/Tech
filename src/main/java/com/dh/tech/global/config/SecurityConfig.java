package com.dh.tech.global.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
        security.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest().authenticated() // 모든 요청은 인증받아야 함.
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/viewName", true)
                        .permitAll()
                )
                .logout(Customizer.withDefaults()); // 로그아웃은 기본값 /logout Post

        return security.build();
    }
}
