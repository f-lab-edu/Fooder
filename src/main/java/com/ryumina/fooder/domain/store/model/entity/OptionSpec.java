package com.ryumina.fooder.domain.store.model.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("OPTION_SPEC")
@Getter
public class OptionSpec {

    @Id
    @Column("OPTION_SPEC_ID")
    private Long id;

    @Column("NAME")
    private String name;

    @Column("PRICE")
    private int price;

}
