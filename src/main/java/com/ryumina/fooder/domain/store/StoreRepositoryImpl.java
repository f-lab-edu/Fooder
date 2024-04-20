package com.ryumina.fooder.domain.store;

import com.ryumina.fooder.domain.store.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.infra.CrudStoreRepository;
import com.ryumina.fooder.infra.FailResult;
import com.ryumina.fooder.infra.exception.FooderBusinessException;
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
        PageRequest pageRequest = PageRequest.of(requestDto.getPage(), requestDto.getSize());

        Page<Store> storePage = crudStoreRepository.findByNameContainingAndFoodCategory(requestDto.getName(),
                                                                                        requestDto.getFoodCategory(),
                                                                                        pageRequest);

        if (storePage.getTotalElements() == 0) {
            throw new FooderBusinessException(FailResult.NO_RESULT.getMessage());
        }

        return storePage.getContent();
    }

}
