package com.ryumina.fooder.domain.store.repository;

import com.ryumina.fooder.domain.store.model.entity.Menu;

import java.util.List;

public interface MenuRepository {
    List<Menu> findByStoreId(Long storeId);

    List<Menu> findAllById(List<Long> menuIdList);
}
