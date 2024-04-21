package com.ryumina.fooder.domain.store;

import com.ryumina.fooder.domain.time.OpeningTime;
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

    @Column("OPEN")
    private boolean open;

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

    public Store(Store store) {
        this.id = store.getId();
        this.name = store.name;
        this.foodCategory = store.foodCategory;
        this.telephoneNumber = store.telephoneNumber;
        this.address = store.address;
        this.minOrderPrice = store.minOrderPrice;
        this.deliveryPrice = store.deliveryPrice;
        this.openingTime = store.openingTime;

        this.setOpenStatus();
    }

    private void open() {
        this.open = true;
    }

    private void close() {
        this.open = false;
    }

    private void setOpenStatus() {
        boolean isOpening = OpeningTime.isOpeningTime(this.openingTime.getStartTime(), this.openingTime.getFinishTime());

        if (isOpening) {
            open();
        }
    }

}
