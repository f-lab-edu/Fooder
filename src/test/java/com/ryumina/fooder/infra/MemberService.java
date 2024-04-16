package com.ryumina.fooder.infra;

public interface MemberService {
    Member insert(Member member);

    Member update(Member member);

    Member findById(Long id);

    void deleteById(Long id);
}
