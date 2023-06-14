package com.dh.tech.global.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
        security.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/status", "images/**", "/login/join").permitAll()
                        .anyRequest().permitAll()// 모든 요청은 인증받아야 함.
                )
                .formLogin(login -> login
                        .loginPage("/login/loginHome")
                        .usernameParameter("userid")
                        .passwordParameter("pw")
                        .defaultSuccessUrl("/login/dashboard",true)
                        .failureForwardUrl("/ERROR")
                        .permitAll()
                )
                .logout(Customizer.withDefaults()); // 로그아웃은 기본값 /logout Post

        return security.build();
    }
}
