package com.ryumina.fooder.store;

import com.ryumina.fooder.domain.store.model.MenuDescription;
import com.ryumina.fooder.domain.store.model.entity.Menu;
import com.ryumina.fooder.domain.store.model.entity.OptionGroupSpec;
import com.ryumina.fooder.domain.store.model.entity.OptionSpec;

import java.util.Arrays;

public class AMenu {
    public static Menu.MenuBuilder aMenu() {
        return Menu.builder()
                   .name("뿌링클 콤보")
                   .menuDescription(aMenuDescription().build())
                   .storeId(1L)
                   .quantity(100)
                   .price(23000)
                   .optionGroupSpecs(Arrays.asList(anOptionGroupSpec_1().build(), anOptionGroupSpec_2().build()));
    }

    public static MenuDescription.MenuDescriptionBuilder aMenuDescription() {
        return MenuDescription.builder()
                              .description("[윙 / 봉 / 닭다리 5조각씩 제공] 뿌링뿌링! 세상에 없던 마법의 맛 뿌링클, 퍽퍽한 닭가슴살 없이 윙, 봉, 닭다리만 담은 콤보")
                              .baseMenuDescription("뿌링클 콤보, 치킨무 1개, 뿌링뿌링 소스 1개, 300ml 펩시콜라 1개");
    }

    public static OptionGroupSpec.OptionGroupSpecBuilder anOptionGroupSpec_1() {
        return OptionGroupSpec.builder()
                              .name("소스")
                              .optionSpecs(Arrays.asList(anOptionSpec_1().build(), anOptionSpec_2().build()));
    }

    public static OptionSpec.OptionSpecBuilder anOptionSpec_1() {
        return OptionSpec.builder()
                         .name("뿌링뿌링소스")
                         .price(1500);
    }

    public static OptionSpec.OptionSpecBuilder anOptionSpec_2() {
        return OptionSpec.builder()
                         .name("매콤소스")
                         .price(1200);
    }

    public static OptionGroupSpec.OptionGroupSpecBuilder anOptionGroupSpec_2() {
        return OptionGroupSpec.builder()
                              .name("디저트")
                              .optionSpecs(Arrays.asList(anOptionSpec_3().build(), anOptionSpec_4().build()));
    }

    public static OptionSpec.OptionSpecBuilder anOptionSpec_3() {
        return OptionSpec.builder()
                         .name("뿌링치즈볼")
                         .price(4500);
    }

    public static OptionSpec.OptionSpecBuilder anOptionSpec_4() {
        return OptionSpec.builder()
                         .name("매콤소떡")
                         .price(3000);
    }

    // 메뉴2
    public static Menu.MenuBuilder aMenu_2() {
        return Menu.builder()
                   .name("마법클")
                   .menuDescription(aMenuDescription_2().build())
                   .storeId(1L)
                   .quantity(80)
                   .price(22000)
                   .optionGroupSpecs(Arrays.asList(anOptionGroupSpec_1().build(), anOptionGroupSpec_2().build()));
    }

    public static MenuDescription.MenuDescriptionBuilder aMenuDescription_2() {
        return MenuDescription.builder()
                              .description("마늘, 버터와 크런치한 후레이크의 마법같은 조합")
                              .baseMenuDescription("마법클, 치킨무 1개, 300ml 펩시콜라 1개");
    }


}
