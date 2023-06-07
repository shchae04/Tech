package com.dh.tech.domain.login;

import com.dh.tech.domain.member.Member;
import com.dh.tech.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository repository;

    public Member login(String loginId, String password) {

        return repository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
}
