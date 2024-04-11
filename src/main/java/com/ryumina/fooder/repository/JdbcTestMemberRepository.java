package com.ryumina.fooder.repository;

import com.ryumina.fooder.domain.JdbcTestMember;
import com.ryumina.fooder.infra.Member;

public interface JdbcTestMemberRepository {
    JdbcTestMember insert(Member member);

    JdbcTestMember update(Member member);

    JdbcTestMember findById(Long id);

    void deleteById(Long id);
}
