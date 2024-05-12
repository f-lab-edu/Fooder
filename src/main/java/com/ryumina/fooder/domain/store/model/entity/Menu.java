package com.ryumina.fooder.domain.store.model.entity;

import com.ryumina.fooder.domain.store.model.MenuDescription;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "MENU")
@Getter
public class Menu {

    @Id
    @Column("MENU_ID")
    private Long id;

    @Column("NAME")
    private String name;

    @Embedded.Empty
    private MenuDescription menuDescription;

    @Column("STORE_ID")
    private Long storeId;

    @Column("PRICE")
    private int price;

    @MappedCollection(idColumn = "MENU_ID", keyColumn = "OPTION_GROUP_SPEC_ID")
    private Set<OptionGroupSpec> optionGroupSpecs = new HashSet<>();

    @Builder
    public Menu(String name, MenuDescription menuDescription, Long storeId, int price, List<OptionGroupSpec> optionGroupSpecs) {
        this(null, name, menuDescription, storeId, price, optionGroupSpecs);
    }

    @Builder
    @PersistenceCreator
    public Menu(Long id, String name, MenuDescription menuDescription,
                Long storeId, int price, List<OptionGroupSpec> optionGroupSpecs) {
        this.id = id;
        this.name = name;
        this.menuDescription = menuDescription;
        this.storeId = storeId;
        this.price = price;
        this.optionGroupSpecs.addAll(optionGroupSpecs);
    }
}
