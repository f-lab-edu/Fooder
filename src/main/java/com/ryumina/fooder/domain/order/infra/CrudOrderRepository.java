package com.ryumina.fooder.domain.order.infra;

import com.ryumina.fooder.domain.order.model.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface CrudOrderRepository extends CrudRepository<Order, Long> {
}
