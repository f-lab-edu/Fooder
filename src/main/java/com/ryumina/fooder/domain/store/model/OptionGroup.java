package com.ryumina.fooder.domain.store.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class OptionGroup {
    private String name;
    private List<Option> options;

    @Builder
    public OptionGroup(String name, List<Option> options) {
        this.name = name;
        this.options = options;
    }
}
