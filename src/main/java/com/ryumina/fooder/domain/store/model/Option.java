package com.ryumina.fooder.domain.store.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Option {
    private String name;
    private int price;

    @Builder
    public Option(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
