package com.ryumina.fooder.domain.order;

import com.ryumina.fooder.domain.order.infra.CrudOrderRepository;
import com.ryumina.fooder.domain.order.model.entity.Order;
import com.ryumina.fooder.domain.order.service.Cart;
import com.ryumina.fooder.domain.order.service.OrderService;
import com.ryumina.fooder.domain.store.infra.CrudMenuRepository;
import com.ryumina.fooder.domain.store.infra.CrudStoreRepository;
import com.ryumina.fooder.order.ACart;
import com.ryumina.fooder.store.AMenu;
import com.ryumina.fooder.store.AStore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CrudOrderRepository crudOrderRepository;

    @Autowired
    private CrudStoreRepository crudStoreRepository;

    @Autowired
    private CrudMenuRepository crudMenuRepository;

    @AfterEach
    void deleteAll() {
        crudOrderRepository.deleteAll();
        crudStoreRepository.deleteAll();
        crudMenuRepository.deleteAll();
    }

    @Test
    public void 주문생성() {
        // given
        Cart cart = dataSet();

        // when
        Order order = orderService.saveOrder(cart);
        Optional<Order> createdOrder = crudOrderRepository.findById(order.getId());

        // then
        Assertions.assertThat(createdOrder.isPresent()).isTrue();
        Assertions.assertThat(createdOrder.get().getId()).isEqualTo(order.getId());
        Assertions.assertThat(createdOrder.get().getTotalPrice()).isEqualTo(60200);
    }

    public Cart dataSet() {
        crudStoreRepository.save(AStore.aOpenStore().build());
        crudMenuRepository.save(AMenu.aMenu());
        return ACart.cart();
    }

}
