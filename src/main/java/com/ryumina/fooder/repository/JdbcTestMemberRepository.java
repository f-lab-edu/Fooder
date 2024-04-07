package com.ryumina.fooder.repository;

import com.ryumina.fooder.domain.JdbcTestMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcTestMemberRepository extends CrudRepository<JdbcTestMember, String>, WithInsert<JdbcTestMember> {
}
