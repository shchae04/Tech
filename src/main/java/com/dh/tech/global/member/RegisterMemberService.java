package com.dh.tech.global.member;

import com.dh.tech.domain.member.Member;
import com.dh.tech.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterMemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository repository;

    public Long join(String userId, String pw) {
        Member member = Member.createUser(userId, pw, passwordEncoder);
        checkDuplicateMember(member);
        repository.save(member);

        return member.getId();
    }

    public void checkDuplicateMember(Member member) {
        repository.findByUserid(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("존재하는 회원입니다.");
                });
    }
}
