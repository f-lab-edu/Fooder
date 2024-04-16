package com.ryumina.fooder.store.domain.impl;

import com.ryumina.fooder.store.domain.JdbcStoreRepository;
import com.ryumina.fooder.store.domain.Store;
import com.ryumina.fooder.store.exception.FooderBusinessException;
import com.ryumina.fooder.store.infra.Result;
import com.ryumina.fooder.store.infra.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcStoreRepositoryImpl implements JdbcStoreRepository {
    private final StoreRepository storeRepository;

    @Override
    public Page<Store> searchStores(int page, int size) {
        Page<Store> storeList = storeRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));

        if (storeList.getTotalElements() == 0) {
            throw new FooderBusinessException(Result.NO_RESULT.getCode(), Result.NO_RESULT.getMessage());
        }

        return storeList;
    }
}
