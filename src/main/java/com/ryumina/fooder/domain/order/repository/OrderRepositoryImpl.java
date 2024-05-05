package com.ryumina.fooder.domain.order.repository;

import com.ryumina.fooder.domain.order.infra.CrudOrderRepository;
import com.ryumina.fooder.domain.order.model.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final CrudOrderRepository crudOrderRepository;

    public Order saveOrder(Order order) {
        return crudOrderRepository.save(order);
    }
}
