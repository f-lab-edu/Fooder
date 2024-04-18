package com.ryumina.fooder.domain.store;

import com.ryumina.fooder.infra.Result;
import com.ryumina.fooder.infra.exception.FooderBusinessException;
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
