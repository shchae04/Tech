package com.dh.tech.global.member;

import com.dh.tech.domain.member.Member;
import com.dh.tech.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public Optional<Member> findOne(String userId) {
        return repository.findByLoginId(userId);
    }
}
