package com.ryumina.fooder.domain.order.repository;

import com.ryumina.fooder.domain.order.model.entity.Order;

public interface OrderRepository {
    Order saveOrder(Order order);

}
