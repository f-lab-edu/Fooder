package com.ryumina.fooder.repository;

import com.ryumina.fooder.domain.JdbcTestMember;
import com.ryumina.fooder.exception.FooderBusinessException;
import com.ryumina.fooder.infra.Member;
import com.ryumina.fooder.infra.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcTestMemberRepositoryImpl implements JdbcTestMemberRepository {
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Member insert(Member member) {
        JdbcTestMember jdbcTestMember = JdbcTestMember.builder()
                                                      .phoneNumber(member.getPhoneNumber())
                                                      .name(member.getName())
                                                      .nickName(member.getNickName())
                                                      .build();

        JdbcTestMember createMember = memberRepository.save(jdbcTestMember);

        return convertToMember(createMember);
    }

    @Transactional
    @Override
    public Member update(Member member) {
        Optional<JdbcTestMember> findMember = memberRepository.findById(member.getId());

        if (findMember.isEmpty()) {
            throw new FooderBusinessException("존재하지 않는 회원입니다. ID= " + member.getId());
        }

        JdbcTestMember savedMember = memberRepository.save(JdbcTestMember.builder()
                                                                         .id(findMember.get().getId())
                                                                         .phoneNumber(member.getPhoneNumber())
                                                                         .name(member.getName())
                                                                         .nickName(member.getNickName())
                                                                         .build());
        return convertToMember(savedMember);
    }

    @Override
    public Member findById(Long id) {
        Optional<JdbcTestMember> findMember = memberRepository.findById(id);

        if (findMember.isPresent()) {
            JdbcTestMember foundMember = findMember.get();

            return convertToMember(foundMember);
        }

        return null;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new FooderBusinessException("존재하지 않는 ID입니다. ID= " + id);
        }

        memberRepository.deleteById(id);
    }

    private Member convertToMember(JdbcTestMember jdbcTestMember) {
        return Member.builder()
                     .id(jdbcTestMember.getId())
                     .phoneNumber(jdbcTestMember.getPhoneNumber())
                     .name(jdbcTestMember.getName())
                     .nickName(jdbcTestMember.getNickName())
                     .build();
    }
}
