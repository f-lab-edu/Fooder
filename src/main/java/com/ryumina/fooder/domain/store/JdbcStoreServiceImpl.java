package com.ryumina.fooder.domain.store;

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
