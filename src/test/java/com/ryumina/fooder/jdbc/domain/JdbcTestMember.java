package com.ryumina.fooder.jdbc.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Getter
@NoArgsConstructor
@Table("MEMBER")
public class JdbcTestMember {
    @Id
    private Long id;

    private String phoneNumber;
    private String name;
    private String nickName;

    public JdbcTestMember(String phoneNumber, String name, String nickName) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.nickName = nickName;
    }

    public JdbcTestMember(Long id, String phoneNumber, String name, String nickName) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.nickName = nickName;
    }
}
