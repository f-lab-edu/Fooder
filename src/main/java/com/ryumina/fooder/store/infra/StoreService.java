package com.ryumina.fooder.store.infra;

import com.ryumina.fooder.store.domain.Store;
import org.springframework.data.domain.Page;

public interface StoreService {
    Page<Store> searchStores(int page, int size);

}
