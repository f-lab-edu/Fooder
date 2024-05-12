package com.ryumina.fooder.domain.order.model.entity;

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

@Table("ORDER_OPTION_GROUP")
@Getter
public class OrderOptionGroup {

    @Id
    @Column("ORDER_OPTION_GROUP_ID")
    private Long id;

    @Column("ORDER_OPTION_GROUP_NAME")
    private String name;

    @MappedCollection(idColumn = "ORDER_OPTION_GROUP_ID", keyColumn = "ORDER_OPTION_ID")
    private Set<OrderOption> orderOptionList = new HashSet<>();

    public OrderOptionGroup(String name, List<OrderOption> orderOptionList) {
        this(null, name, orderOptionList);
    }

    @Builder
    @PersistenceCreator
    public OrderOptionGroup(Long id, String name, List<OrderOption> orderOptionList) {
        this.id = id;
        this.name = name;
        this.orderOptionList.addAll(orderOptionList);
    }

    public int getOptionPrice() {
        return orderOptionList.stream().mapToInt(OrderOption::getPrice).sum();
    }

}
