package com.ryumina.fooder.order;

import com.ryumina.fooder.domain.order.service.Cart;

public class ACart {
    // cart item 1
    public static Cart cart() {
        return new Cart(1L, 1L, aCartItem_1(), aCartItem_2());
    }

    public static Cart.CartItem aCartItem_1() {
        return new Cart.CartItem(1L, "뿌링클 콤보", 1, 23000, aCartOptionGroup_1(), aCartOptionGroup_2());
    }

    public static Cart.CartOptionGroup aCartOptionGroup_1() {
        return new Cart.CartOptionGroup("소스", aCartOption_1(), aCartOption_2());
    }

    public static Cart.CartOptionGroup aCartOptionGroup_2() {
        return new Cart.CartOptionGroup("디저트", aCartOption_3(), aCartOption_4());
    }

    public static Cart.CartOption aCartOption_1() {
        return new Cart.CartOption("뿌링뿌링소스", 1500);
    }

    public static Cart.CartOption aCartOption_2() {
        return new Cart.CartOption("매콤소스", 1200);
    }

    public static Cart.CartOption aCartOption_3() {
        return new Cart.CartOption("뿌링치즈볼", 4500);
    }

    public static Cart.CartOption aCartOption_4() {
        return new Cart.CartOption("매콤소떡", 3000);
    }

    // cart item 2
    public static Cart.CartItem aCartItem_2() {
        return new Cart.CartItem(2L, "마법클", 1, 22000, aCartOptionGroup_3());
    }

    public static Cart.CartOptionGroup aCartOptionGroup_3() {
        return new Cart.CartOptionGroup("디저트", aCartOption_5());
    }

    public static Cart.CartOption aCartOption_5() {
        return new Cart.CartOption("뿌링치즈볼", 5000);
    }

}
