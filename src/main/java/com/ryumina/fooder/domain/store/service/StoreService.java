package com.ryumina.fooder.domain.store.service;

import com.ryumina.fooder.domain.store.controller.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.model.Store;
import com.ryumina.fooder.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public List<Store> searchStores(StoreSearchRequestDto requestDto) {
        List<Store> stores = storeRepository.searchStores(requestDto);

        return stores;
    }
}
