package com.ryumina.fooder.domain.store;

import org.springframework.data.domain.Page;

public interface JdbcStoreRepository {
    Page<Store> searchStores(int page, int size);

}
