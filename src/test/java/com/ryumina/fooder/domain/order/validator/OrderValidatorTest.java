package com.ryumina.fooder.domain.order.validator;

import com.ryumina.fooder.domain.order.model.entity.Order;
import com.ryumina.fooder.domain.store.model.entity.Store;
import com.ryumina.fooder.domain.store.repository.StoreRepository;
import com.ryumina.fooder.exception.FooderBusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static com.ryumina.fooder.domain.order.fixtures.Fixtures.anOrder;
import static com.ryumina.fooder.domain.store.fixtures.Fixtures.aNotOpenStore;
import static com.ryumina.fooder.domain.store.fixtures.Fixtures.aOpenStore;

@ExtendWith(MockitoExtension.class)
class OrderValidatorTest {

    @InjectMocks
    private OrderValidator orderValidator;

    @Mock
    private StoreRepository storeRepository;

    @DisplayName("가게가 영업중이 아닐 시 예외 발생 테스트")
    @Test
    void isNotOpenStore() {
        // given
        Store store = aNotOpenStore().build();
        Order order = anOrder().build();

        Assertions.assertThatThrownBy(() -> orderValidator.validate(order, store))
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("가게가 영업중이 아닙니다.");

    }

    @DisplayName("주문 항목이 비어 있을 시 예외 발생 테스트")
    @Test
    void isEmptyOrderItemList() {
        // given
        Store store = aOpenStore().build();
        Order order = anOrder().orderItemList(Collections.emptyList()).build();

        Assertions.assertThatThrownBy(() -> orderValidator.validate(order, store))
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("주문 항목이 비어 있습니다.");

    }

    @DisplayName("최소 주문 금액을 만족하지 않을 시 예외 발생 테스트")
    @Test
    void isNotValidMinOrderPrice() {
        // given
        Store store = aOpenStore().minOrderPrice(50000).build();
        Order order = anOrder().build();

        Assertions.assertThatThrownBy(() -> orderValidator.validate(order, store))
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("최소 주문 금액을 만족하지 않습니다.");

    }

}
