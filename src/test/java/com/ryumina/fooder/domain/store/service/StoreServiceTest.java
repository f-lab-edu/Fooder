package com.ryumina.fooder.domain.store.service;

import com.ryumina.fooder.domain.store.controller.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.model.MenuBoard;
import com.ryumina.fooder.domain.store.model.OptionGroupSpec;
import com.ryumina.fooder.domain.store.model.OptionSpec;
import com.ryumina.fooder.domain.store.model.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StoreServiceTest {
    @Autowired
    private StoreService storeService;

    @DisplayName("가게 전체 목록을 조회 테스트")
    @Test
    void searchStores() {
        // given
        StoreSearchRequestDto requestDto = new StoreSearchRequestDto(null);

        // when
        List<Store> storeList = storeService.searchStores(requestDto);

        // then
        Assertions.assertThat(storeList.size()).isEqualTo(3);
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

    @DisplayName("가게 목록 조회시 페이징이 정상적으로 적용되는 지 테스트")
    @Test
    void searchStoresWithPaging() {
        // given
        StoreSearchRequestDto requestDto = new StoreSearchRequestDto(null, 0, 2);

        // when
        List<Store> storeList = storeService.searchStores(requestDto);

        // then
        Assertions.assertThat(storeList.size()).isEqualTo(2);
    }

    @DisplayName("가게 목록 조회시 페이징이 정상적으로 적용되는 지 테스트_데이터가 없는 페이지를 조회하는 경우")
    @Test
    void searchStoresWithPagingNoData() {
        // given
        StoreSearchRequestDto requestDto = new StoreSearchRequestDto(null, 5, 2);

        // when
        List<Store> storeList = storeService.searchStores(requestDto);

        // then
        Assertions.assertThat(storeList.size()).isEqualTo(0);
    }

    @DisplayName("가게 메뉴 조회 테스트")
    @Test
    void getMenuBoard() {
        // given
        Long storeId = 1L;

        // when
        MenuBoard menuBoard = storeService.getMenuBoard(storeId);
        List<MenuBoard.MenuItem> menuItemList = menuBoard.getMenuItemList();
        List<OptionGroupSpec> optionGroupSpecList = menuItemList.get(0).getOptionGroupSpecList();
        List<OptionSpec> optionSpecs = optionGroupSpecList.get(0).getOptionSpecs();

        // then
        Assertions.assertThat(menuBoard.getMenuItemList()).isNotEmpty();
        Assertions.assertThat(menuItemList.size()).isEqualTo(3);
        Assertions.assertThat(optionGroupSpecList.size()).isEqualTo(3);
        Assertions.assertThat(optionSpecs.size()).isEqualTo(3);
    }

}
