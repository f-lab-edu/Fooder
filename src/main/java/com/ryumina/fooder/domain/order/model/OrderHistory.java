package com.ryumina.fooder.domain.order.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("ORDER_HISTORY")
@Getter
public class OrderHistory {
    // 히스토리는 말 그대로 이력을 관리하기 때문에 변경이 일어나서는 안되는 객체.
    // 즉, 수정 로직이 들어가서는 안된다.

    @Id
    @Column("ORDER_HISTORY_ID")
    private Long id;

    @Column("ORDER_STATUS")
    private OrderStatus orderStatus;    // 트랜잭션이 발생한 주문 상태

    @Column("TX_DATE_TIME")
    private LocalDateTime txDateTime;   // 트랜잭션이 발생한 시점

    @Builder
    public OrderHistory(OrderStatus orderStatus, LocalDateTime txDateTime) {
        this.orderStatus = orderStatus;
        this.txDateTime = txDateTime;
    }
}
