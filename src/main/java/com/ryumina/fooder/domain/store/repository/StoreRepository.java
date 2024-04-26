package com.ryumina.fooder.domain.store.repository;

import com.ryumina.fooder.domain.store.controller.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.model.Store;

import java.util.List;

public interface StoreRepository {
    List<Store> searchStores(StoreSearchRequestDto storeSearchRequestDto);
}
