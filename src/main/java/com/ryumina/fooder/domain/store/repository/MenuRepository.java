package com.ryumina.fooder.domain.store.repository;

import com.ryumina.fooder.domain.store.model.Menu;

import java.util.List;

public interface MenuRepository {
    List<Menu> findByStoreId(Long storeId);
}
