package com.ryumina.fooder.domain.store.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MenuDescription {
    private String description;
    private String baseMenuDescription;

    @Builder
    public MenuDescription(String description, String baseMenuDescription) {
        this.description = description;
        this.baseMenuDescription = baseMenuDescription;
    }
}
