package com.ryumina.fooder.jdbc.service;

import com.ryumina.fooder.jdbc.domain.Member;
import com.ryumina.fooder.jdbc.repository.TestMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final TestMemberRepository testMemberRepository;

    public Member insert(Member member) {
        return testMemberRepository.insert(member);
    }

    public Member update(Member member) {
        return testMemberRepository.update(member);
    }

    public Member findById(Long id) {
        return testMemberRepository.findById(id);
    }

    public void deleteById(Long id) {
        testMemberRepository.deleteById(id);
    }

}
