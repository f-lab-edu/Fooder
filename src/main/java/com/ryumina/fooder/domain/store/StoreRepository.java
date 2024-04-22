package com.ryumina.fooder.domain.store;

import com.ryumina.fooder.domain.store.dto.request.StoreSearchRequestDto;

import java.util.List;

public interface StoreRepository {
    List<Store> searchStores(StoreSearchRequestDto storeSearchRequestDto);
}
