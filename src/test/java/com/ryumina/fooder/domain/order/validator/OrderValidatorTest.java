package com.ryumina.fooder.domain.order.validator;

import com.ryumina.fooder.domain.order.infra.CrudOrderRepository;
import com.ryumina.fooder.domain.order.model.entity.Order;
import com.ryumina.fooder.domain.store.infra.CrudMenuRepository;
import com.ryumina.fooder.domain.store.infra.CrudStoreRepository;
import com.ryumina.fooder.domain.store.model.entity.Menu;
import com.ryumina.fooder.domain.store.model.entity.Store;
import com.ryumina.fooder.domain.store.repository.MenuRepository;
import com.ryumina.fooder.exception.FooderBusinessException;
import com.ryumina.fooder.order.AnOrder;
import com.ryumina.fooder.store.AMenu;
import com.ryumina.fooder.store.AStore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashMap;

// TODO: MOCK -> STUB 변경 필요
@ExtendWith(MockitoExtension.class)
class OrderValidatorTest {

    @InjectMocks
    private OrderValidator orderValidator;

    @Mock
    private CrudStoreRepository crudStoreRepository;

    @Mock
    private CrudOrderRepository crudOrderRepository;

    @Mock
    private CrudMenuRepository crudMenuRepository;

    @Mock
    private MenuRepository menuRepository;

    @DisplayName("가게가 영업중이 아닐 시 예외 발생 테스트")
    @Test
    void isNotOpenStore() {
        // given
        Store store = getANotOpenStore();
        Order order = getAnOrder();

        Assertions.assertThatThrownBy(() -> orderValidator.validate(order, store, new HashMap<>()))
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("가게가 영업중이 아닙니다.");

    }

    @DisplayName("주문 항목이 비어 있을 시 예외 발생 테스트")
    @Test
    void isEmptyOrderItemList() {
        // given
        Store store = getAOpenStore();
        Order order = AnOrder.order().orderItemList(Collections.emptySet()).build();

        Assertions.assertThatThrownBy(() -> orderValidator.validate(order, store, new HashMap<>()))
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("주문 항목이 비어 있습니다.");

    }

    @DisplayName("최소 주문 금액을 만족하지 않을 시 예외 발생 테스트")
    @Test
    void isNotValidMinOrderPrice() {
        // given
        Store store = AStore.aOpenStore().minOrderPrice(50000).build();
        Order order = getAnOrder();

        Assertions.assertThatThrownBy(() -> orderValidator.validate(order, store, new HashMap<>()))
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("최소 주문 금액을 만족하지 않습니다.");

    }

    @DisplayName("주문이 불가능한 경우 예외 발생 테스트")
    @Test
    void isNotPossibleOrder() {
        // given
        Store store = AStore.aOpenStore().build();
        Order order = AnOrder.order().build();

        Assertions.assertThatThrownBy(() -> orderValidator.validate(order, store, new HashMap<>()))
                  .isInstanceOf(FooderBusinessException.class)
                  .hasMessageContaining("주문이 불가능한 메뉴입니다.");
    }

//    TODO: 추후 STUB 객체를 이용하여 테스트 코드 작성 필요
//    @DisplayName("메뉴가 품절된 경우 예외 발생 테스트")
//    @Test
//    void isNotPossibleOrder_noQuantity() {
//        // given
//        Store store = AStore.aOpenStore().build();
//        Order order = AnOrder.order().build();
//
//        Store actualStore = crudStoreRepository.save(store);
//        Menu actualMenu = crudMenuRepository.save(AMenu.aMenu().quantity(0).build());
//        Order actualOrder = crudOrderRepository.save(order);
//
//        Assertions.assertThatThrownBy(() -> orderValidator.validate(actualOrder, actualStore, List.of(actualMenu)))
//                  .isInstanceOf(FooderBusinessException.class)
//                  .hasMessageContaining("주문이 불가능한 메뉴입니다.");
//    }

    Order getAnOrder() {
        return AnOrder.order().build();
    }

    Store getANotOpenStore() {
        return AStore.aNotOpenStore().build();
    }

    Store getAOpenStore() {
        return AStore.aOpenStore().build();
    }

    Menu getAMenu() {
        return AMenu.aMenu().build();
    }

}
