package com.back.domain.member.member.repository;

import com.back.domain.member.member.entity.Member;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findQByUsername(String username);

    long qCount();
}
