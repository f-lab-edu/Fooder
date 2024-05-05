package com.ryumina.fooder.domain.order.model.entity;

import com.ryumina.fooder.domain.order.model.OrderStatus;
import com.ryumina.fooder.domain.order.service.Cart;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<OrderItem> orderItemList = new ArrayList<>();

    @Column("ORDERED_TIME")
    private LocalDateTime orderedTime;

    @Column("ORDER_STATUS")
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(Long userId, Long storeId, List<OrderItem> itemList) {
        this(null, userId, storeId, itemList, LocalDateTime.now(), null);
    }

    @Builder
    public Order(Long id, Long userId, Long storeId, List<OrderItem> orderItemList,
                 LocalDateTime orderedTime, OrderStatus orderStatus) {
        this.id = id;
        this.userId = userId;
        this.storeId = storeId;
        this.orderedTime = orderedTime;
        this.orderStatus = orderStatus;
        this.orderItemList.addAll(orderItemList);
    }

    public void init() {
        ordered();
    }

    public static Order from(Cart cart) {
        return new Order(cart.getUserId(),
                         cart.getStoreId(),
                         cart.getCartItemList()
                             .stream()
                             .map(OrderItem::from)
                             .collect(Collectors.toList())
        );
    }

    // 주문완료
    public void ordered() {
        this.orderStatus = OrderStatus.ORDERED;
    }

    // 배달완료
    public void delivered() {
        this.orderStatus = OrderStatus.DELIVERED;
    }

    // 주문취소
    public void canceled() {
        this.orderStatus = OrderStatus.CANCELED;
    }

    public int getTotalPrice() {
        return orderItemList.stream().mapToInt(OrderItem::getItemPrice).sum();
    }
}
