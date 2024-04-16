package com.ryumina.fooder.store.domain;

import org.springframework.data.domain.Page;

public interface JdbcStoreRepository {
    Page<Store> searchStores(int page, int size);

}
