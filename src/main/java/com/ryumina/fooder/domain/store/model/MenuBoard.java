package com.ryumina.fooder.domain.store.model;

import com.ryumina.fooder.domain.store.model.entity.Menu;
import com.ryumina.fooder.domain.store.model.entity.OptionGroupSpec;
import com.ryumina.fooder.domain.store.model.entity.Store;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MenuBoard {
    private Long storeId;
    private String storeName;
    private boolean open;
    private int minOrderPrice;
    private List<MenuItem> menuItemList;

    public MenuBoard(Store store, List<Menu> menus) {
        this.storeId = store.getId();
        this.storeName = store.getName();
        this.open = store.isOpen();
        this.minOrderPrice = store.getMinOrderPrice();
        this.menuItemList = toMenuItems(menus);
    }

    private List<MenuItem> toMenuItems(List<Menu> menus) {
        return menus.stream().map(MenuItem::new).collect(Collectors.toList());
    }

    @Getter
    public class MenuItem {
        private Long menuId;
        private String menuName;
        private int menuBasePrice;
        private String menuDescription;
        private String baseMenuDescription;
        private List<OptionGroupSpec> optionGroupSpecList;

        public MenuItem(Menu menu) {
            this.menuId = menu.getId();
            this.menuName = menu.getName();
            this.menuBasePrice = menu.getPrice();
            this.menuDescription = menu.getMenuDescription().getDescription();
            this.baseMenuDescription = menu.getMenuDescription().getBaseMenuDescription();
            this.optionGroupSpecList = menu.getOptionGroupSpecs();
        }
    }

}
