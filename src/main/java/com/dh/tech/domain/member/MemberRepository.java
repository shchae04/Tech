package com.dh.tech.domain.member;

import java.util.*;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence;

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream().filter(member -> member.getLoginId().equals(loginId)).findFirst();
    }

    // 구현 예정
    public String findPw() {
        return "";
    }


}
