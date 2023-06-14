package com.dh.tech;

import com.dh.tech.domain.member.Member;
import com.dh.tech.domain.member.MemberRepository;
import com.dh.tech.domain.member.Roles;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestClass {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void initialize() {
        Member member = new Member();
        member.setLoginId("test");
        member.setUserName("chae");
        member.setPassword("test");
        member.setMemberRoles(Roles.SA.toString());
        memberRepository.save(member);
    }
}
