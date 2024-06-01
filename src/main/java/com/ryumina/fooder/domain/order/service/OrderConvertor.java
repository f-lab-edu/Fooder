package com.ryumina.fooder.domain.order.service;

import com.ryumina.fooder.domain.order.model.entity.Order;
import com.ryumina.fooder.domain.order.model.entity.OrderItem;
import com.ryumina.fooder.domain.order.model.entity.OrderOption;
import com.ryumina.fooder.domain.order.model.entity.OrderOptionGroup;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderConvertor {

    public Order toOrder(Cart cart) {
        return new Order(cart.getUserId(),
                         cart.getStoreId(),
                         cart.getCartItemList()
                             .stream()
                             .map(this::toOrderItem)
                             .collect(Collectors.toSet())
        );
    }

    public OrderItem toOrderItem(Cart.CartItem cartItem) {
        return new OrderItem(cartItem.getMenuId(),
                             cartItem.getMenuName(),
                             cartItem.getPrice(),
                             cartItem.getCount(),
                             cartItem.getCartOptionGroupList()
                                     .stream()
                                     .map(this::toOrderOptionGroup)
                                     .collect(Collectors.toList())
        );
    }

    public OrderOptionGroup toOrderOptionGroup(Cart.CartOptionGroup cartOptionGroup) {
        return new OrderOptionGroup(cartOptionGroup.getName(),
                                    cartOptionGroup.getCartOptionList()
                                                   .stream()
                                                   .map(this::toOrderOption)
                                                   .collect(Collectors.toList())
        );
    }

    public OrderOption toOrderOption(Cart.CartOption cartOption) {
        return new OrderOption(cartOption.getName(),
                               cartOption.getPrice());
    }

}
