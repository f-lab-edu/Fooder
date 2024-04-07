package com.ryumina.fooder.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("MEMBER")
public class JdbcTestMember {
    @Id
    @Column("PHONE_NUMBER")
    private String phoneNumber;

    @Column("NAME")
    private String name;

    @Column("NICK_NAME")
    private String nickName;

    public JdbcTestMember(String phoneNumber, String name, String nickName) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.nickName = nickName;
    }
}
