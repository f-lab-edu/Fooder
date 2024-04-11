package com.ryumina.fooder.infra;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("MEMBER")
@NoArgsConstructor
public class Member {

    @Id
    @Column("ID")
    private Long id;

    @Column("PHONE_NUMBER")
    private String phoneNumber;

    @Column("NAME")
    private String name;

    @Column("NICK_NAME")
    private String nickName;

    public Member(String phoneNumber, String name, String nickName) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.nickName = nickName;
    }

    @Builder
    public Member(Long id, String phoneNumber, String name, String nickName) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.nickName = nickName;
    }
}
