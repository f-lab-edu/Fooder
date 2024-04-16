package com.ryumina.fooder.store.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Builder
@Getter
public class Store {

    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String foodCategory;

    @Size(min = 10, max = 11, message = "올바른 전화번호 양식이 아닙니다.")
    private String telephoneNumber;

    @NotNull
    @Size(max = 5)
    private String zipCode;

    @NotNull
    @Size(max = 255)
    private String address;

    @NotNull
    @Size(max = 255)
    private String detailAddress;

    @NotNull
    @Size(max = 10)
    private String bizNumber;

    @NotNull
    @PositiveOrZero
    private Integer minOrderPrice;

    @NotNull
    @PositiveOrZero
    private Integer deliveryPrice;

    @NotNull
    private String orderPossibleType;

    @NotNull
    private String payPossibleType;

    @NotNull
    private String status;

    @NotNull
    @Size(min = 4, max = 4)
    private String startTime;

    @NotNull
    @Size(min = 4, max = 4)
    private String finishTime;

//    @NotNull
//    private String deliveryLocation;

    private String ownerNotification;

}
