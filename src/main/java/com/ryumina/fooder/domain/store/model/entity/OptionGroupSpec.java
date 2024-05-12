package com.ryumina.fooder.domain.store.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table("OPTION_GROUP_SPEC")
@Getter
public class OptionGroupSpec {

    @Id
    @Column("OPTION_GROUP_SPEC_ID")
    private Long id;

    @Column("NAME")
    private String name;

    @MappedCollection(idColumn = "OPTION_GROUP_SPEC_ID", keyColumn = "OPTION_SPEC_ID")
    private Set<OptionSpec> optionSpecs = new HashSet<>();

    @Builder
    public OptionGroupSpec(String name, List<OptionSpec> optionSpecs) {
        this(null, name, optionSpecs);
    }

    @Builder
    @PersistenceCreator
    public OptionGroupSpec(Long id, String name, List<OptionSpec> optionSpecs) {
        this.id = id;
        this.name = name;
        this.optionSpecs.addAll(optionSpecs);
    }
}
