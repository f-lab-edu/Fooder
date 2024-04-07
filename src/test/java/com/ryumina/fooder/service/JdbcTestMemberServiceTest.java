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

import java.util.Optional;

@SpringBootTest
@AutoConfigureDataJdbc
class JdbcTestMemberServiceTest {

    @Autowired
    JdbcTestMemberRepository jdbcTestMemberRepository;

    @BeforeEach
    void initData() {
        jdbcTestMemberRepository.deleteAll();
    }

    @DisplayName("멤버를 생성한다")
    @Test
    void createMember() {
        // given
        JdbcTestMember member = new JdbcTestMember("01088888888", "김옥수수", "옥수수");

        // when
        JdbcTestMember createdMember = jdbcTestMemberRepository.insert(member);

        // then
        Assertions.assertThat(createdMember.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
    }

    @DisplayName("멤버를 조회한다")
    @Test
    void createAndFindMember() {
        // given
        JdbcTestMember member = new JdbcTestMember("01077777777", "류찰밥", "찰밥");
        JdbcTestMember insertedMember = jdbcTestMemberRepository.insert(member);

        // when
        JdbcTestMember findMember = jdbcTestMemberRepository.findById(insertedMember.getPhoneNumber()).get();

        // then
        Assertions.assertThat(findMember.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
    }

    @DisplayName("멤버 정보를 수정한다")
    @Test
    void updateMember() {
        // given
        JdbcTestMember member = new JdbcTestMember("01077777777", "류찰밥", "찰밥");
        JdbcTestMember insertedMember = jdbcTestMemberRepository.insert(member);

        // when
        insertedMember.setNickName("찰밥_수정수정");
        JdbcTestMember updatedMember = jdbcTestMemberRepository.save(insertedMember);

        // then
        Assertions.assertThat(updatedMember.getNickName()).isEqualTo("찰밥_수정수정");
    }

    @DisplayName("멤버를 삭제한다")
    @Test
    void deleteMember() {
        // given
        JdbcTestMember member = new JdbcTestMember("01077777777", "류찰밥", "찰밥");

        // when
        jdbcTestMemberRepository.deleteById(member.getPhoneNumber());
        Optional<JdbcTestMember> isDeletedMember = jdbcTestMemberRepository.findById(member.getPhoneNumber());

        // then
        Assertions.assertThat(isDeletedMember.isPresent()).isFalse();
    }

}