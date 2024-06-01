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

import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Component
@RequiredArgsConstructor
public class OrderValidator {
    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    public void validate(Order order) {
        validate(order, getStore(order.getStoreId()), getMenus(order));
    }

    // TODO: private 로 변경하여 테스트코드 작성 필요
    void validate(Order order, Store store, Map<Long, Menu> menus) {
        if (!store.isOpen()) {
            throw new FooderBusinessException("가게가 영업중이 아닙니다.");
        }

        if (order.getOrderItemList().isEmpty()) {
            throw new FooderBusinessException("주문 항목이 비어 있습니다.");
        }

        if (!store.isValidMinOrderPrice(order.getTotalPrice())) {
            throw new FooderBusinessException("최소 주문 금액을 만족하지 않습니다.");
        }

        if (CollectionUtils.isEmpty(menus)) {
            throw new FooderBusinessException("주문이 불가능한 메뉴입니다.");
        }

        for (OrderItem orderItem : order.getOrderItemList()) {
            validateOrderItem(orderItem, menus.get(orderItem.getMenuId()));
        }
    }

    private void validateOrderItem(OrderItem orderItem, Menu menu) {
        if (!menu.getName().equals(orderItem.getName())) {
            throw new FooderBusinessException("메뉴가 변경되었습니다.");
        }

        if (menu.getQuantity() == 0) {
            throw new FooderBusinessException("메뉴가 품절되었습니다.");
        }

        for (OrderOptionGroup orderOptionGroup : orderItem.getOrderOptionGroupList()) {
            validateOrderOptionGroup(orderOptionGroup, menu);
        }
    }

    private void validateOrderOptionGroup(OrderOptionGroup orderOptionGroup, Menu menu) {
        for (OptionGroupSpec optionGroupSpec : menu.getOptionGroupSpecs()) {
            // 실제 db에 저장되어 있는 메뉴의 옵션과 고객이 주문한 메뉴의 옵션이 동일한지 검증
            // (domain) order => store 객체로 변경하여 비교하기 위해 convert 과정을 진행
            if (optionGroupSpec.isEqualsBy(orderOptionGroup.convertToOptionGroup())) {
                return;
            }

            throw new FooderBusinessException("메뉴가 변경되었습니다.");
        }
    }

    private Store getStore(Long storeId) {
        return storeRepository.findById(storeId);
    }

    private Map<Long, Menu> getMenus(Order order) {
        return menuRepository.findAllById(order.getMenuIdList()).stream().collect(toMap(Menu::getId, identity()));
    }

}
