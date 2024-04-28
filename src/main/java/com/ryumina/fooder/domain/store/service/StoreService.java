package com.ryumina.fooder.domain.store.service;

import com.ryumina.fooder.domain.store.controller.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.model.Menu;
import com.ryumina.fooder.domain.store.model.MenuBoard;
import com.ryumina.fooder.domain.store.model.Store;
import com.ryumina.fooder.domain.store.repository.MenuRepository;
import com.ryumina.fooder.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    @Transactional(readOnly = true)
    public List<Store> searchStores(StoreSearchRequestDto requestDto) {
        List<Store> stores = storeRepository.searchStores(requestDto);

        return stores;
    }

    @Transactional(readOnly = true)
    public MenuBoard getMenuBoard(Long storeId) {
        Store store = storeRepository.findById(storeId);
        List<Menu> menuList = menuRepository.findByStoreId(store.getId());

        return new MenuBoard(store, menuList);
    }
}
