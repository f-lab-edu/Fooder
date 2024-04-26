package com.ryumina.fooder.jdbc.infra;

import com.ryumina.fooder.jdbc.domain.JdbcTestMember;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<JdbcTestMember, Long> {
}
