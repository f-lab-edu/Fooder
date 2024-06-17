package com.ryumina.fooder.domain.store.model.entity;

import com.ryumina.fooder.domain.store.model.Address;
import com.ryumina.fooder.domain.store.model.FoodCategory;
import com.ryumina.fooder.domain.store.model.OpeningTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
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

    public Store() {
    }

    @Builder
    public Store(String name, FoodCategory foodCategory, String telephoneNumber, Address address,
                 int minOrderPrice, int deliveryPrice, OpeningTime openingTime) {
        this(null, name, foodCategory, telephoneNumber, address, minOrderPrice, deliveryPrice, openingTime);
    }

    @Builder
    @PersistenceCreator
    public Store(Long id, String name, FoodCategory foodCategory, String telephoneNumber, Address address,
                 int minOrderPrice, int deliveryPrice, OpeningTime openingTime) {
        this.id = id;
        this.name = name;
        this.foodCategory = foodCategory;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.minOrderPrice = minOrderPrice;
        this.deliveryPrice = deliveryPrice;
        this.openingTime = openingTime;
    }

    public boolean isOpen() {
        return this.openingTime.isOpeningTime(this.openingTime.getStartTime(), this.openingTime.getFinishTime());
    }

    public boolean isValidMinOrderPrice(int orderPrice) {
        return orderPrice >= this.minOrderPrice;
    }

}
