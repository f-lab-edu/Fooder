package com.ryumina.fooder.store.service.impl;

import com.ryumina.fooder.store.domain.JdbcStoreRepository;
import com.ryumina.fooder.store.domain.Store;
import com.ryumina.fooder.store.infra.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JdbcStoreServiceImpl implements StoreService {
    private final JdbcStoreRepository jdbcStoreRepository;

    @Override
    public Page<Store> searchStores(int page, int size) {
        return jdbcStoreRepository.searchStores(page, size);
    }
}
