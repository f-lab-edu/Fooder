package com.ryumina.fooder.domain.store.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Address {
    private String zipCode;
    private String address;
    private String detailAddress;

    public Address() {
    }

    @Builder
    public Address(String zipCode, String address, String detailAddress) {
        this.zipCode = zipCode;
        this.address = address;
        this.detailAddress = detailAddress;
    }
}
