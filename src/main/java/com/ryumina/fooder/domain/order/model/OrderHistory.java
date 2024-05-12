package com.ryumina.fooder.domain.order.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderHistory {
    // 주문시간
    private LocalDateTime orderDateTime;

    // 취소시간
    private LocalDateTime cancelDateTime;

    // 배달완료시간
    private LocalDateTime deliveredDateTime;

    // 배달시작시간
    private LocalDateTime deliveringStartTime;

    public OrderHistory() {
        this(LocalDateTime.now(), null, null, null);
    }

    @Builder
    public OrderHistory(LocalDateTime orderDateTime, LocalDateTime cancelDateTime,
                        LocalDateTime deliverDateTime, LocalDateTime deliveringStartTime) {
        this.orderDateTime = orderDateTime;
        this.cancelDateTime = cancelDateTime;
        this.deliveredDateTime = deliverDateTime;
        this.deliveringStartTime = deliveringStartTime;
    }

}
