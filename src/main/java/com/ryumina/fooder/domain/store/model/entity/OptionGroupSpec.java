package com.ryumina.fooder.domain.store.model.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("OPTION_GROUP_SPEC")
@Getter
public class OptionGroupSpec {

    @Id
    @Column("OPTION_GROUP_SPEC_ID")
    private Long id;

    @Column("NAME")
    private String name;

    @MappedCollection(idColumn = "OPTION_GROUP_SPEC_ID", keyColumn = "OPTION_SPEC_ID")
    private List<OptionSpec> optionSpecs;
}
