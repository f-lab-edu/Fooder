package com.ryumina.fooder.jdbc.service;

import com.ryumina.fooder.jdbc.domain.Member;
import com.ryumina.fooder.jdbc.exception.FooderBusinessException;
import com.ryumina.fooder.jdbc.infra.MemberRepository;
import com.ryumina.fooder.jdbc.repository.TestMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcTestMemberServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TestMemberRepository jdbcTestMemberRepository;
    @Autowired
    MemberService memberService;

    @AfterEach
    void deleteAllData() {
        memberRepository.deleteAll();
    }

    @DisplayName("멤버를 생성한다")
    @Test
    void createMember() {
        // given
        Member member = Member.builder()
                              .phoneNumber("01088888888")
                              .name("김옥수수")
                              .nickName("옥수수")
                              .build();

        // when
        Member createdMember = memberService.insert(member);
        Member findMember = memberService.findById(createdMember.getId());

        // then
        Assertions.assertThat(createdMember.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(createdMember.getPhoneNumber()).isEqualTo(findMember.getPhoneNumber());
        Assertions.assertThat(createdMember.getName()).isEqualTo(findMember.getName());
        Assertions.assertThat(createdMember.getNickName()).isEqualTo(findMember.getNickName());
    }

    @DisplayName("멤버를 조회한다")
    @Test
    void findMember() {
        // given
        Member member = Member.builder()
                              .phoneNumber("01077777777")
                              .name("류찰밥")
                              .nickName("찰밥")
                              .build();

        Member createdMember = memberService.insert(member);

        // when
        Member findMember = memberService.findById(createdMember.getId());

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(createdMember.getId());
        Assertions.assertThat(findMember.getPhoneNumber()).isEqualTo(createdMember.getPhoneNumber());
        Assertions.assertThat(findMember.getName()).isEqualTo(createdMember.getName());
        Assertions.assertThat(findMember.getNickName()).isEqualTo(createdMember.getNickName());
    }

    @DisplayName("멤버 정보를 수정한다")
    @Test
    void updateMember() {
        // given
        Member member = Member.builder()
                              .phoneNumber("01077777777")
                              .name("류찰밥")
                              .nickName("찰밥")
                              .build();

        Member createdMember = memberService.insert(member);

        // when
        Member updatedMember = memberService.update(Member.builder()
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
        Assertions.assertThatThrownBy(() -> {memberService.update(notExistMember);})
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("존재하지 않는 회원입니다. ID= " + notExistMember.getId());
    }

    @DisplayName("멤버를 삭제한다")
    @Test
    void deleteMember() {
        // given
        Member member = Member.builder()
                              .phoneNumber("01077777777")
                              .name("류찰밥")
                              .nickName("찰밥")
                              .build();

        Member createdMember = memberService.insert(member);
        Member findMember = memberService.findById(createdMember.getId());

        // when
        memberService.deleteById(findMember.getId());
        Member deletedMember = memberService.findById(findMember.getId());

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
        Assertions.assertThatThrownBy(() -> {memberService.deleteById(notExistMember.getId());})
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("존재하지 않는 ID입니다. ID= " + notExistMember.getId());
    }

}
