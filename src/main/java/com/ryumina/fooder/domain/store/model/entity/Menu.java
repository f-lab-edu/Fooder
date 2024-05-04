package com.ryumina.fooder.domain.store.model.entity;

import com.ryumina.fooder.domain.store.model.MenuDescription;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

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
    private List<OptionGroupSpec> optionGroupSpecs;

}
