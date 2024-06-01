package com.ryumina.fooder.domain.store.model.entity;

import com.ryumina.fooder.domain.store.model.Option;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

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

    @Builder
    public OptionSpec(String name, int price) {
        this(null, name, price);
    }

    @Builder
    @PersistenceCreator
    public OptionSpec(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public boolean isEquals(Option option) {
        return Objects.equals(name, option.getName()) && Objects.equals(price, option.getPrice());
    }
}
