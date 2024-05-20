package com.ryumina.fooder.domain.order.validator;

import com.ryumina.fooder.domain.order.model.entity.Order;
import com.ryumina.fooder.domain.order.model.entity.OrderItem;
import com.ryumina.fooder.domain.order.model.entity.OrderOptionGroup;
import com.ryumina.fooder.domain.store.model.entity.Menu;
import com.ryumina.fooder.domain.store.model.entity.OptionGroupSpec;
import com.ryumina.fooder.domain.store.model.entity.Store;
import com.ryumina.fooder.domain.store.repository.MenuRepository;
import com.ryumina.fooder.domain.store.repository.StoreRepository;
import com.ryumina.fooder.exception.FooderBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderValidator {
    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    public void validate(Order order) {
        validate(order, getStore(order.getStoreId()), getMenuList(order.getMenuIdList()));
    }

    void validate(Order order, Store store, List<Menu> menuList) {
        if (!store.isOpen()) {
            throw new FooderBusinessException("가게가 영업중이 아닙니다.");
        }

        if (order.getOrderItemList().isEmpty()) {
            throw new FooderBusinessException("주문 항목이 비어 있습니다.");
        }

        if (!store.isValidMinOrderPrice(order.getTotalPrice())) {
            throw new FooderBusinessException("최소 주문 금액을 만족하지 않습니다.");
        }

        // TODO: 해당 검증이 의미가 있는지?
        // TODO: 카트에 담아뒀다가 시간이 어느정도 지난 후 주문하려고 하는데 메뉴가 삭제됐다거나..?
        if (CollectionUtils.isEmpty(menuList)) {
            throw new FooderBusinessException("주문이 불가능한 메뉴입니다.");
        }

        for (OrderItem orderItem : order.getOrderItemList()) {
            validateOrderItem(orderItem, menuList);
        }
    }

    private void validateOrderItem(OrderItem orderItem, List<Menu> menuList) {
        Menu menuItem = menuList.stream()
                                .filter(menu -> menu.getId().equals(orderItem.getId()))
                                .findFirst().get();

        if (!orderItem.getName().equals(menuItem.getName())) {
            throw new FooderBusinessException("메뉴가 변경되었습니다.");
        }

        if (menuItem.getQuantity() == 0) {
            throw new FooderBusinessException("메뉴가 품절되었습니다.");
        }

        for (OrderOptionGroup orderOptionGroup : orderItem.getOrderOptionGroupList()) {
            OptionGroupSpec optionGroupSpec = menuItem.getOptionGroupSpecs().stream()
                                                      .filter(optionGroup -> optionGroup.getId().equals(orderOptionGroup.getId()))
                                                      .findFirst().get();

            if (!orderOptionGroup.getName().equals(optionGroupSpec.getName())) {
                throw new FooderBusinessException("옵션이 변경되었습니다.");
            }
        }
    }

    private Store getStore(Long storeId) {
        return storeRepository.findById(storeId);
    }

    private List<Menu> getMenuList(List<Long> menuIdList) {
        return menuRepository.findAllById(menuIdList);
    }

}
