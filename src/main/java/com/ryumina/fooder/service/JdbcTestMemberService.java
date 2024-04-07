package com.ryumina.fooder.service;

import com.ryumina.fooder.domain.JdbcTestMember;
import com.ryumina.fooder.repository.JdbcTestMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JdbcTestMemberService {
    private final JdbcTestMemberRepository jdbcTestMemberRepository;

    @Autowired
    public JdbcTestMemberService(JdbcTestMemberRepository jdbcTestMemberRepository) {
        this.jdbcTestMemberRepository = jdbcTestMemberRepository;
    }

    public JdbcTestMember createMember(JdbcTestMember member) {
        return jdbcTestMemberRepository.insert(member);
    }

    public JdbcTestMember findMember(String phoneNumber) {
        Optional<JdbcTestMember> findMember = jdbcTestMemberRepository.findById(phoneNumber);

        return findMember.orElse(null);
    }

    public JdbcTestMember updateMember(JdbcTestMember member) {
        return jdbcTestMemberRepository.save(member);
    }

    public void deleteMember(String phoneNumber) {
        jdbcTestMemberRepository.deleteById(phoneNumber);
    }
}
