package com.ryumina.fooder.domain.store;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "STORE")
@Getter
public class Store {

    @Id
    @Column("STORE_ID")
    private Long id;

    @Column("NAME")
    private String name;

    @Column("FOOD_CATEGORY")
    private FoodCategory foodCategory;

    @Column("TELEPHONE_NUMBER")
    private String telephoneNumber;

    @Embedded.Empty
    private Address address;

    @Column("MIN_ORDER_PRICE")
    private int minOrderPrice;

    @Column("DELIVERY_PRICE")
    private int deliveryPrice;

    @Embedded.Empty
    private OpeningTime openingTime;

    public boolean isOpen() {
        return this.openingTime.isOpeningTime(this.openingTime.getStartTime(), this.openingTime.getFinishTime());
    }

}
