package com.ryumina.fooder.domain.order.model.entity;

import com.ryumina.fooder.domain.order.model.OrderHistory;
import com.ryumina.fooder.domain.order.model.OrderStatus;
import com.ryumina.fooder.domain.order.validator.OrderValidator;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
    private Set<OrderItem> orderItemList = new LinkedHashSet<>();

    @MappedCollection(idColumn = "ORDER_ID", keyColumn = "ORDER_HISTORY_ID")
    private Set<OrderHistory> orderHistory = new LinkedHashSet<>();

    public Order(Long userId, Long storeId, Set<OrderItem> itemList) {
        this(null, userId, storeId, itemList);
    }

    @Builder
    @PersistenceCreator
    public Order(Long id, Long userId, Long storeId, Set<OrderItem> orderItemList) {
        this.id = id;
        this.userId = userId;
        this.storeId = storeId;
        this.orderHistory.add(OrderHistory.builder()
                                          .orderStatus(OrderStatus.WAITING)
                                          .txDateTime(LocalDateTime.now())
                                          .build());
        this.orderItemList.addAll(orderItemList);
    }

    public void order(OrderValidator orderValidator) {
        orderValidator.validate(this);
        ordered();
    }

    // 주문완료
    public void ordered() {
        this.orderHistory.add(OrderHistory.builder()
                                          .orderStatus(OrderStatus.ORDERED)
                                          .txDateTime(LocalDateTime.now())
                                          .build());
    }

    // 준비중
    public void preparing() {
        this.orderHistory.add(OrderHistory.builder()
                                          .orderStatus(OrderStatus.PREPARING)
                                          .txDateTime(LocalDateTime.now())
                                          .build());
    }

    // 주문취소
    public void canceled() {
        this.orderHistory.add(OrderHistory.builder()
                                          .orderStatus(OrderStatus.CANCELED)
                                          .txDateTime(LocalDateTime.now())
                                          .build());
    }

    public int getTotalPrice() {
        return orderItemList.stream().mapToInt(OrderItem::getItemPrice).sum();
    }

    public List<Long> getMenuIdList() {
        return this.getOrderItemList().stream().map(OrderItem::getMenuId).collect(Collectors.toList());
    }
}
