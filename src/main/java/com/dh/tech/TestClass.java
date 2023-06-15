package com.dh.tech;


import com.dh.tech.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestClass {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void initialize() {
    }
}
