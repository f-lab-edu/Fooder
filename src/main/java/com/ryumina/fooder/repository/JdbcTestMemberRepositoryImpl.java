package com.ryumina.fooder.repository;

import com.ryumina.fooder.domain.JdbcTestMember;
import com.ryumina.fooder.infra.Member;
import com.ryumina.fooder.exception.FooderBusinessException;
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
    public JdbcTestMember insert(Member member) {
        Member createMember = memberRepository.save(member);

        return convertToJdbcTestMember(createMember);
    }

    @Transactional
    @Override
    public JdbcTestMember update(Member member) {
        Optional<Member> findMember = memberRepository.findById(member.getId());

        if (findMember.isEmpty()) {
            throw new FooderBusinessException("존재하지 않는 회원입니다. ID= " + member.getId());
        }

        Member savedMember = memberRepository.save(Member.builder()
                                                         .id(findMember.get().getId())
                                                         .phoneNumber(member.getPhoneNumber())
                                                         .name(member.getName())
                                                         .nickName(member.getNickName())
                                                         .build());
        return convertToJdbcTestMember(savedMember);
    }

    @Override
    public JdbcTestMember findById(Long id) {
        Optional<Member> findMember = memberRepository.findById(id);

        if (findMember.isPresent()) {
            Member foundMember = findMember.get();

            return convertToJdbcTestMember(foundMember);
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

    private JdbcTestMember convertToJdbcTestMember(Member member) {
        return JdbcTestMember.builder()
                             .id(member.getId())
                             .phoneNumber(member.getPhoneNumber())
                             .name(member.getName())
                             .nickName(member.getNickName())
                             .build();
    }
}
