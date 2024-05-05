package com.ryumina.fooder.domain.order.service;

import com.ryumina.fooder.domain.order.model.entity.Order;
import com.ryumina.fooder.domain.order.repository.OrderRepository;
import com.ryumina.fooder.domain.order.validator.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;

    @Transactional
    public Order saveOrder(Cart cart) {
        Order order = Order.from(cart);

        orderValidator.validate(order);
        order.init();

        return orderRepository.saveOrder(order);
    }

}
