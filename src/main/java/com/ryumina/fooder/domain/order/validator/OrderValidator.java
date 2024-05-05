package com.ryumina.fooder.domain.order.validator;

import com.ryumina.fooder.domain.order.model.entity.Order;
import com.ryumina.fooder.domain.store.model.entity.Store;
import com.ryumina.fooder.domain.store.repository.StoreRepository;
import com.ryumina.fooder.exception.FooderBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderValidator {
    private final StoreRepository storeRepository;

    public void validate(Order order) {
        validate(order, getStore(order.getStoreId()));
    }

    void validate(Order order, Store store) {
        if (!store.isOpen()) {
            throw new FooderBusinessException("가게가 영업중이 아닙니다.");
        }

        if (order.getOrderItemList().isEmpty()) {
            throw new FooderBusinessException("주문 항목이 비어 있습니다.");
        }

        if (!store.isValidMinOrderPrice(order.getTotalPrice())) {
            throw new FooderBusinessException("최소 주문 금액을 만족하지 않습니다.");
        }
    }

    private Store getStore(Long storeId) {
        return storeRepository.findById(storeId);
    }

}
