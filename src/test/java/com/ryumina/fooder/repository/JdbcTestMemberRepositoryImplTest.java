package com.ryumina.fooder.repository;

import com.ryumina.fooder.domain.JdbcTestMember;
import com.ryumina.fooder.exception.FooderBusinessException;
import com.ryumina.fooder.infra.Member;
import com.ryumina.fooder.infra.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcTestMemberRepositoryImplTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    JdbcTestMemberRepository jdbcTestMemberRepository = new JdbcTestMemberRepositoryImpl(memberRepository);

    @AfterEach
    void deleteAllData() {
        memberRepository.deleteAll();
    }

    @DisplayName("멤버를 생성한다")
    @Test
    void createMember() {
        // given
        Member member = new Member("01088888888", "김옥수수", "옥수수");

        // when
        JdbcTestMember createdMember = jdbcTestMemberRepository.insert(member);

        // then
        Assertions.assertThat(createdMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(createdMember.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
        Assertions.assertThat(createdMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(createdMember.getNickName()).isEqualTo(member.getNickName());
    }

    @DisplayName("멤버를 조회한다")
    @Test
    void findMember() {
        // given
        Member member = new Member("01077777777", "류찰밥", "찰밥");
        JdbcTestMember createdMember = jdbcTestMemberRepository.insert(member);

        // when
        JdbcTestMember findMember = jdbcTestMemberRepository.findById(createdMember.getId());

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(findMember.getNickName()).isEqualTo(member.getNickName());
    }

    @DisplayName("멤버 정보를 수정한다")
    @Test
    void updateMember() {
        // given
        Member member = new Member("01077777777", "류찰밥", "찰밥");
        JdbcTestMember createdMember = jdbcTestMemberRepository.insert(member);

        // when
        JdbcTestMember updatedMember = jdbcTestMemberRepository.update(Member.builder()
                                                                             .id(createdMember.getId())
                                                                             .phoneNumber(createdMember.getPhoneNumber())
                                                                             .name(createdMember.getName())
                                                                             .nickName("찰밥_수정수정")
                                                                             .build());

        // then
        Assertions.assertThat(updatedMember.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
        Assertions.assertThat(updatedMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(updatedMember.getNickName()).isEqualTo("찰밥_수정수정");
    }

    @DisplayName("존재하지 않는 멤버 정보를 수정할 때 FooderBusinessException이 발생한다.")
    @Test
    void updateNotExistMember() {
        // given
        Member notExistMember = Member.builder()
                                      .id(1111L)
                                      .phoneNumber("01012341234")
                                      .name("류찰밥")
                                      .nickName("찰밥")
                                      .build();

        // when, then
        Assertions.assertThatThrownBy(() -> {jdbcTestMemberRepository.update(notExistMember);})
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("존재하지 않는 회원입니다. ID= " + notExistMember.getId());
    }

    @DisplayName("멤버를 삭제한다")
    @Test
    void deleteMember() {
        // given
        Member member = new Member("01077777777", "류찰밥", "찰밥");
        jdbcTestMemberRepository.insert(member);

        // when
        jdbcTestMemberRepository.deleteById(member.getId());
        JdbcTestMember deletedMember = jdbcTestMemberRepository.findById(member.getId());

        // then
        Assertions.assertThat(deletedMember).isNull();
    }

    @DisplayName("존재하지 않는 멤버를 삭제할 때 FooderBusinessException이 발생한다.")
    @Test
    void deleteNotExistMember() {
        // given
        Member notExistMember = Member.builder()
                                      .id(1111L)
                                      .phoneNumber("01012341234")
                                      .name("류찰밥")
                                      .nickName("찰밥")
                                      .build();

        // when, then
        Assertions.assertThatThrownBy(() -> {jdbcTestMemberRepository.deleteById(notExistMember.getId());})
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("존재하지 않는 ID입니다. ID= " + notExistMember.getId());
    }

}
