package com.ryumina.fooder.service;

import com.ryumina.fooder.infra.Member;
import com.ryumina.fooder.infra.MemberService;
import com.ryumina.fooder.repository.JdbcTestMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JdbcTestMemberServiceImpl implements MemberService {
    private final JdbcTestMemberRepository jdbcTestMemberRepository;

    @Override
    public Member insert(Member member) {
        return jdbcTestMemberRepository.insert(member);
    }

    @Override
    public Member update(Member member) {
        return jdbcTestMemberRepository.update(member);
    }

    @Override
    public Member findById(Long id) {
        return jdbcTestMemberRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTestMemberRepository.deleteById(id);
    }
}
