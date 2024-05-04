package com.ryumina.fooder.domain.store.repository;

import com.ryumina.fooder.domain.store.controller.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.infra.CrudStoreRepository;
import com.ryumina.fooder.domain.store.model.entity.Store;
import com.ryumina.fooder.exception.FooderBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepository {
    private final CrudStoreRepository crudStoreRepository;

    @Override
    public List<Store> searchStores(StoreSearchRequestDto requestDto) {
        List<Store> storeList = crudStoreRepository.findAllBy(requestDto.getFoodCategory(), requestDto.getSize(), requestDto.getPage());

        return storeList;
    }

    @Override
    public Store findById(Long storeId) {
        Optional<Store> store = crudStoreRepository.findById(storeId);

        if (store.isEmpty()) {
            throw new FooderBusinessException("존재하지 않는 가게입니다.");
        }

        return store.get();
    }

}
