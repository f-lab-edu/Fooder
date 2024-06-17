package com.ryumina.fooder.jdbc.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
public class Member {

    private Long id;
    private String phoneNumber;
    private String name;
    private String nickName;

    public Member(String phoneNumber, String name, String nickName) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.nickName = nickName;
    }

    public Member(Long id, String phoneNumber, String name, String nickName) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.nickName = nickName;
    }
}
