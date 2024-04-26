package com.ryumina.fooder.domain.store.repository;

import com.ryumina.fooder.domain.store.controller.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.infra.CrudStoreRepository;
import com.ryumina.fooder.domain.store.model.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepository {
    private final CrudStoreRepository crudStoreRepository;

    @Override
    public List<Store> searchStores(StoreSearchRequestDto requestDto) {
        Page<Store> storePage = crudStoreRepository.findByNameContainingAndFoodCategory(requestDto.getName(),
                                                                                        requestDto.getFoodCategory(),
                                                                                        PageRequest.of(requestDto.getPage(),
                                                                                                       requestDto.getSize()));

        return storePage.getContent();
    }

}
