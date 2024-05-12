package com.ryumina.fooder.domain.order.model.entity;

import com.ryumina.fooder.domain.order.model.OrderHistory;
import com.ryumina.fooder.domain.order.model.OrderStatus;
import com.ryumina.fooder.domain.order.validator.OrderValidator;
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

@Table("ORDER")
@Getter
public class Order {

    @Id
    @Column("ORDER_ID")
    private Long id;

    @Column("USER_ID")
    private Long userId;

    @Column("STORE_ID")
    private Long storeId;

    @MappedCollection(idColumn = "ORDER_ID", keyColumn = "ORDER_ITEM_ID")
    private Set<OrderItem> orderItemList = new HashSet<>();

    @Embedded.Empty
    private OrderHistory orderHistory;

    @Column("ORDER_STATUS")
    private OrderStatus orderStatus;

    public Order(Long userId, Long storeId, List<OrderItem> itemList) {
        this(null, userId, storeId, new OrderHistory(), itemList, OrderStatus.WAITING);
    }

    @Builder
    @PersistenceCreator
    public Order(Long id, Long userId, Long storeId, OrderHistory orderHistory,
                 List<OrderItem> orderItemList, OrderStatus orderStatus) {
        this.id = id;
        this.userId = userId;
        this.storeId = storeId;
        this.orderHistory = orderHistory;
        this.orderStatus = orderStatus;
        this.orderItemList.addAll(orderItemList);
    }

    public void order(OrderValidator orderValidator) {
        orderValidator.validate(this);
        ordered();
    }

    // 주문완료
    public void ordered() {
        this.orderStatus = OrderStatus.ORDERED;
    }

    // 준비중
    public void preparing() {
        this.orderStatus = OrderStatus.PREPARING;
    }

    // 주문취소
    public void canceled() {
        this.orderStatus = OrderStatus.CANCELED;
    }

    public int getTotalPrice() {
        return orderItemList.stream().mapToInt(OrderItem::getItemPrice).sum();
    }
}
