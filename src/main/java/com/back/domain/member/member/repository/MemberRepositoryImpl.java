package com.back.domain.member.member.repository;

import com.back.domain.member.member.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.back.domain.member.member.entity.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Member> findByUsername(String username) {
        Member result = queryFactory
                .selectFrom(member)
                .where(member.username.eq(username))
                .fetchOne();

        return Optional.ofNullable(result);
    }

    @Override
    public long count() {
        Long count = queryFactory
                .select(member.count())
                .from(member)
                .fetchOne();

        return count != null ? count : 0L;
    }
}
