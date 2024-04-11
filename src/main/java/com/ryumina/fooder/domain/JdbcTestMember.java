package com.ryumina.fooder.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JdbcTestMember {
    private Long id;
    private String phoneNumber;
    private String name;
    private String nickName;

    @Builder
    public JdbcTestMember(Long id, String phoneNumber, String name, String nickName) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.nickName = nickName;
    }
}
