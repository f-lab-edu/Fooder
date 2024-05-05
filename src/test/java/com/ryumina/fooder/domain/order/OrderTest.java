package com.ryumina.fooder.domain.order;

import com.ryumina.fooder.domain.order.infra.CrudOrderRepository;
import com.ryumina.fooder.domain.order.model.entity.Order;
import com.ryumina.fooder.domain.order.service.Cart;
import com.ryumina.fooder.domain.order.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CrudOrderRepository crudOrderRepository;

    @BeforeEach
    void dataInit() {
        this.dataSet();
    }

    @AfterEach
    void deleteAll() {
        crudOrderRepository.deleteAll();
    }

    @Test
    public void 주문생성() {
        // given
        Cart cart = dataSet();

        // when
        Order order = orderService.saveOrder(cart);

        // then
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(59700);
    }

    public Cart dataSet() {
        // menu 1
        Cart.CartOption option_1 = new Cart.CartOption("뿌링뿌링소스", 1500);
        Cart.CartOption option_2 = new Cart.CartOption("매콤소스", 1200);
        Cart.CartOptionGroup optionGroup_1 = new Cart.CartOptionGroup("소스", option_1, option_2);

        Cart.CartOption option_3 = new Cart.CartOption("뿌링치즈볼", 4500);
        Cart.CartOption option_4 = new Cart.CartOption("매콤소떡", 3000);
        Cart.CartOptionGroup optionGroup_2 = new Cart.CartOptionGroup("디저트", option_3, option_4);

        Cart.CartItem item_1 = new Cart.CartItem(1L, "뿌링클 콤보", 1, 23000, optionGroup_1, optionGroup_2);

        // menu 2
        Cart.CartOption option_5 = new Cart.CartOption("뿌링치즈볼", 4500);
        Cart.CartOptionGroup optionGroup_3 = new Cart.CartOptionGroup("디저트", option_5);

        Cart.CartItem item_2 = new Cart.CartItem(2L, "마법클", 1, 22000, optionGroup_3);

        Cart cart = new Cart(2L, 1L, item_1, item_2);

        return cart;
    }

}
