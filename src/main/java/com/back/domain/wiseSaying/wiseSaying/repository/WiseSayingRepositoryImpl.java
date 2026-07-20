package com.back.domain.wiseSaying.wiseSaying.repository;

import com.back.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.back.domain.wiseSaying.wiseSaying.entity.QWiseSaying.wiseSaying;

@RequiredArgsConstructor
public class WiseSayingRepositoryImpl implements WiseSayingRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<WiseSaying> findQById(Integer id) {
        WiseSaying result = queryFactory
                .selectFrom(wiseSaying)
                .where(wiseSaying.id.eq(id))
                .fetchOne();

        return Optional.ofNullable(result);
    }

    @Override
    public List<WiseSaying> findQAll() {
        return queryFactory
                .selectFrom(wiseSaying)
                .fetch();
    }

    @Override
    public long qCount() {
        Long count = queryFactory
                .select(wiseSaying.count())
                .from(wiseSaying)
                .fetchOne();

        return count != null ? count : 0L;
    }
}
