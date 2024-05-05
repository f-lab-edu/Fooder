package com.ryumina.fooder.domain.order.service;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Getter
public class Cart {

    private Long storeId;
    private Long userId;
    private List<CartItem> cartItemList;

    public Cart(Long storeId, Long userId, CartItem... cartItems) {
        this.storeId = storeId;
        this.userId = userId;
        this.cartItemList = Arrays.asList(cartItems);
    }

    @NoArgsConstructor
    @Getter
    public static class CartItem {
        private Long menuId;
        private String menuName;
        private int price;
        private int count;
        private List<CartOptionGroup> cartOptionGroupList;

        public CartItem(Long menuId, String menuName, int count, int price, CartOptionGroup... cartOptionGroups) {
            this.menuId = menuId;
            this.menuName = menuName;
            this.count = count;
            this.price = price;
            this.cartOptionGroupList = Arrays.asList(cartOptionGroups);
        }
    }

    @NoArgsConstructor
    @Getter
    public static class CartOptionGroup {
        private String name;
        private List<CartOption> cartOptionList;

        public CartOptionGroup(String name, CartOption... cartOptions) {
            this.name = name;
            this.cartOptionList = Arrays.asList(cartOptions);
        }
    }

    @NoArgsConstructor
    @Getter
    public static class CartOption {
        private String name;
        private int price;

        public CartOption(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

}
