package com.ryumina.fooder.domain.order.fixtures;

import com.ryumina.fooder.domain.order.model.entity.Order;
import com.ryumina.fooder.domain.order.model.entity.Order.OrderBuilder;
import com.ryumina.fooder.domain.order.model.entity.OrderItem;
import com.ryumina.fooder.domain.order.model.entity.OrderItem.OrderItemBuilder;
import com.ryumina.fooder.domain.order.model.entity.OrderOption;
import com.ryumina.fooder.domain.order.model.entity.OrderOption.OrderOptionBuilder;
import com.ryumina.fooder.domain.order.model.entity.OrderOptionGroup;
import com.ryumina.fooder.domain.order.model.entity.OrderOptionGroup.OrderOptionGroupBuilder;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Fixtures {
    // 하나의 order data 생성
    public static OrderBuilder anOrder() {
        return Order.builder()
                    .id(1L)
                    .userId(1L)
                    .storeId(1L)
                    .orderDateTime(LocalDateTime.of(2024, 5, 1, 11, 23))
                    .orderItemList(Arrays.asList(anOrderItem().build()));
    }

    // 하나의 주문 메뉴 생성
    public static OrderItemBuilder anOrderItem() {
        return OrderItem.builder()
                        .id(1L)
                        .menuId(1L)
                        .name("뿌링클 콤보")
                        .price(23000)
                        .count(1)
                        .orderOptionGroupList(
                            Arrays.asList(anOrderOptionGroup_1().build(),
                                          anOrderOptionGroup_2().build()
                            )
                        );
    }

    // 하나의 옵션 그룹 생성_1
    public static OrderOptionGroupBuilder anOrderOptionGroup_1() {
        return OrderOptionGroup.builder()
                               .id(1L)
                               .name("소스")
                               .orderOptionList(
                                   Arrays.asList(anOrderOption_1_1().build(),
                                                 anOrderOption_1_2().build(),
                                                 anOrderOption_1_3().build())
                               );
    }

    // 하나의 옵션 그룹 생성_2
    public static OrderOptionGroupBuilder anOrderOptionGroup_2() {
        return OrderOptionGroup.builder()
                               .id(1L)
                               .name("디저트")
                               .orderOptionList(
                                   Arrays.asList(anOrderOption_2_1().build(),
                                                 anOrderOption_2_2().build())
                               );
    }

    // 소스 옵션 생성_1_1
    public static OrderOptionBuilder anOrderOption_1_1() {
        return OrderOption.builder()
                          .name("뿌링뿌링 소스")
                          .price(1500);
    }

    // 소스 옵션 생성_1_2
    public static OrderOptionBuilder anOrderOption_1_2() {
        return OrderOption.builder()
                          .name("매콤소스")
                          .price(1000);
    }

    // 소스 옵션 생성_1_3
    public static OrderOptionBuilder anOrderOption_1_3() {
        return OrderOption.builder()
                          .name("핫뿌링뿌링 소스")
                          .price(1200);
    }

    // 디저트 옵션 생성_2_1
    public static OrderOptionBuilder anOrderOption_2_1() {
        return OrderOption.builder()
                          .name("달콤바삭 치즈볼")
                          .price(4000);
    }

    // 디저트 옵션 생성_2_2
    public static OrderOptionBuilder anOrderOption_2_2() {
        return OrderOption.builder()
                          .name("뿌링치즈볼")
                          .price(4500);
    }
}
