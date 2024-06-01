package com.ryumina.fooder.domain.store.service;

import com.ryumina.fooder.domain.store.controller.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.infra.CrudMenuRepository;
import com.ryumina.fooder.domain.store.infra.CrudStoreRepository;
import com.ryumina.fooder.domain.store.model.MenuBoard;
import com.ryumina.fooder.domain.store.model.entity.OptionGroupSpec;
import com.ryumina.fooder.domain.store.model.entity.Store;
import com.ryumina.fooder.store.AMenu;
import com.ryumina.fooder.store.AStore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
class StoreServiceTest {
    @Autowired
    private StoreService storeService;

    @Autowired
    private CrudStoreRepository crudStoreRepository;

    @Autowired
    private CrudMenuRepository crudMenuRepository;

    private Store store;

    @BeforeEach
    void storeAndMenuDataSet() {
        this.store = this.dataSet();
    }

    @AfterEach
    void deleteAll() {
        crudStoreRepository.deleteAll();
        crudMenuRepository.deleteAll();
    }

    @DisplayName("가게 전체 목록을 조회 테스트")
    @Test
    void searchStores() {
        // given
        StoreSearchRequestDto requestDto = new StoreSearchRequestDto(null);

        // when
        List<Store> storeList = storeService.searchStores(requestDto);

        // then
        Assertions.assertThat(storeList.size()).isEqualTo(1);
    }

    @DisplayName("가게 목록 조회시 요청 파라미터 테스트_존재하는 foodCategory")
    @Test
    void searchStoresWithFoodCategory() {
        // given
        StoreSearchRequestDto requestDto = new StoreSearchRequestDto("CHICKEN", 0, 10);

        // when
        List<Store> storeList = storeService.searchStores(requestDto);

        // then
        Assertions.assertThat(storeList.size()).isEqualTo(1);
    }

    @DisplayName("가게 목록 조회시 요청 파라미터 테스트_존재하지 않는 foodCategory")
    @Test
    void searchStoresWithFoodCategoryNoData() {
        // given
        StoreSearchRequestDto requestDto = new StoreSearchRequestDto("DESSERT", 0, 10);

        // when
        List<Store> storeList = storeService.searchStores(requestDto);

        // then
        Assertions.assertThat(storeList.size()).isEqualTo(0);
    }

//    TODO: 추후 페이징 방식 변경 후 작성
//    @DisplayName("가게 목록 조회시 페이징이 정상적으로 적용되는 지 테스트")
//    @Test
//    void searchStoresWithPaging() {
//        // given
//        StoreSearchRequestDto requestDto = new StoreSearchRequestDto(null, 0, 2);
//
//        // when
//        List<Store> storeList = storeService.searchStores(requestDto);
//
//        // then
//        Assertions.assertThat(storeList.size()).isEqualTo(2);
//    }

//    TODO: 추후 페이징 방식 변경 후 작성
//    @DisplayName("가게 목록 조회시 페이징이 정상적으로 적용되는 지 테스트_데이터가 없는 페이지를 조회하는 경우")
//    @Test
//    void searchStoresWithPagingNoData() {
//        // given
//        StoreSearchRequestDto requestDto = new StoreSearchRequestDto(null, 5, 2);
//
//        // when
//        List<Store> storeList = storeService.searchStores(requestDto);
//
//        // then
//        Assertions.assertThat(storeList.size()).isEqualTo(0);
//    }

    @DisplayName("가게 메뉴 조회 테스트")
    @Test
    void getMenuBoard() {
        // given
        Long storeId = this.store.getId();

        // when
        MenuBoard menuBoard = storeService.getMenuBoard(storeId);
        List<MenuBoard.MenuItem> menuItemList = menuBoard.getMenuItemList();
        Set<OptionGroupSpec> optionGroupSpecList = menuItemList.get(0).getOptionGroupSpecList();

        // then
        Assertions.assertThat(menuBoard.getMenuItemList()).isNotEmpty();
        Assertions.assertThat(menuItemList.size()).isEqualTo(1);
        Assertions.assertThat(optionGroupSpecList.size()).isEqualTo(2);
        Assertions.assertThat(optionGroupSpecList.iterator().next().getOptionSpecs().size()).isEqualTo(2);
    }

    public Store dataSet() {
        Store Store = crudStoreRepository.save(AStore.aOpenStore().build());
        crudMenuRepository.save(AMenu.aMenu().build());
        return Store;
    }

}
