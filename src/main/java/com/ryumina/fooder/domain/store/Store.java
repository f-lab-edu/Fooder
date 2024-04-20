package com.ryumina.fooder.domain.store;

import com.ryumina.fooder.domain.time.Time;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "STORE")
@Getter
public class Store {
    public enum FoodCategory {CHICKEN, PIZZA, BURGER, MEAT, SALAD, SUSHI, SANDWICH}

    @Id
    @Column("STORE_ID")
    private Long id;

    @Column("NAME")
    private String name;

    @Column("OPEN")
    private boolean open;

    @Column("FOOD_CATEGORY")
    private FoodCategory foodCategory;

    @Column("TELEPHONE_NUMBER")
    private String telephoneNumber;

    @MappedCollection(idColumn = "STORE_ID")
    private Address address;

    @Column("MIN_ORDER_PRICE")
    private int minOrderPrice;

    @Column("DELIVERY_PRICE")
    private int deliveryPrice;

    @MappedCollection(idColumn = "STORE_ID")
    private Time time;

    public Store() {
    }

    public void open() {
        this.open = true;
    }

    public void close() {
        this.open = false;
    }

}
