package com.ryumina.fooder.service;

import com.ryumina.fooder.domain.JdbcTestMember;
import com.ryumina.fooder.repository.JdbcTestMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureDataJdbc
class JdbcTestMemberServiceTest {

    @Autowired
    JdbcTestMemberRepository jdbcTestMemberRepository;
    @Autowired
    JdbcTestMemberService jdbcTestMemberService;

    @BeforeEach
    void deleteAllData() {
        jdbcTestMemberRepository.deleteAll();
    }

    @DisplayName("멤버를 생성한다")
    @Test
    void createMember() {
        // given
        JdbcTestMember member = new JdbcTestMember("01088888888", "김옥수수", "옥수수");

        // when
        JdbcTestMember createdMember = jdbcTestMemberService.createMember(member);

        // then
        Assertions.assertThat(createdMember.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
    }

    @DisplayName("멤버를 조회한다")
    @Test
    void createAndFindMember() {
        // given
        JdbcTestMember member = new JdbcTestMember("01077777777", "류찰밥", "찰밥");
        JdbcTestMember createdMember = jdbcTestMemberService.createMember(member);

        // when
        JdbcTestMember findMember = jdbcTestMemberService.findMember(createdMember.getPhoneNumber());

        // then
        Assertions.assertThat(findMember).isNotNull();
        Assertions.assertThat(findMember.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
    }

    @DisplayName("멤버 정보를 수정한다")
    @Test
    void updateMember() {
        // given
        JdbcTestMember member = new JdbcTestMember("01077777777", "류찰밥", "찰밥");
        JdbcTestMember createdMember = jdbcTestMemberService.createMember(member);

        // when
        createdMember.setNickName("찰밥_수정수정");
        JdbcTestMember updatedMember = jdbcTestMemberService.updateMember(createdMember);

        // then
        Assertions.assertThat(updatedMember.getNickName()).isEqualTo("찰밥_수정수정");
    }

    @DisplayName("멤버를 삭제한다")
    @Test
    void deleteMember() {
        // given
        JdbcTestMember member = new JdbcTestMember("01077777777", "류찰밥", "찰밥");

        // when
        jdbcTestMemberService.deleteMember(member.getPhoneNumber());
        JdbcTestMember deletedMember = jdbcTestMemberService.findMember(member.getPhoneNumber());

        // then
        Assertions.assertThat(deletedMember).isNull();
    }

}