package com.ryumina.fooder.domain.store.repository;

import com.ryumina.fooder.domain.store.controller.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.model.entity.Store;

import java.util.List;

public interface StoreRepository {
    List<Store> searchStores(StoreSearchRequestDto storeSearchRequestDto);

    Store findById(Long storeId);
}
