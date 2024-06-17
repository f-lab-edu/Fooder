package com.ryumina.fooder.domain.order.model;

public enum OrderStatus {
    // 주문대기, 주문완료, 준비중, 주문취소
    WAITING, ORDERED, PREPARING, CANCELED;
}
