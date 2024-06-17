package com.ryumina.fooder.jdbc.repository;

import com.ryumina.fooder.jdbc.domain.Member;

public interface TestMemberRepository {
    Member insert(Member member);

    Member update(Member member);

    Member findById(Long id);

    void deleteById(Long id);
}
