package com.ryumina.fooder.infra;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@NoArgsConstructor
public class Member {

    @Id
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
