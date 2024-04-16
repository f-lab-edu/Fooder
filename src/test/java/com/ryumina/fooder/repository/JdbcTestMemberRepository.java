package com.ryumina.fooder.repository;

import com.ryumina.fooder.infra.Member;

public interface JdbcTestMemberRepository {
    Member insert(Member member);

    Member update(Member member);

    Member findById(Long id);

    void deleteById(Long id);
}
