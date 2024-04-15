package com.ryumina.fooder.infra;

import com.ryumina.fooder.domain.JdbcTestMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<JdbcTestMember, Long> {
}
