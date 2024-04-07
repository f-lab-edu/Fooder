package com.ryumina.fooder.service;

import com.ryumina.fooder.domain.JdbcTestMember;
import com.ryumina.fooder.repository.JdbcTestMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JdbcTestMemberService {
    private final JdbcTestMemberRepository jdbcTestMemberRepository;

    @Autowired
    public JdbcTestMemberService(JdbcTestMemberRepository jdbcTestMemberRepository) {
        this.jdbcTestMemberRepository = jdbcTestMemberRepository;
    }

    public JdbcTestMember createMember(JdbcTestMember member) {
        return jdbcTestMemberRepository.save(member);
    }
}
