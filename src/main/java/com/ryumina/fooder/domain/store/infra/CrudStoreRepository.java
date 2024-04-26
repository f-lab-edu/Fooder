package com.ryumina.fooder.domain.store.infra;

import com.ryumina.fooder.domain.store.model.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CrudStoreRepository extends PagingAndSortingRepository<Store, Long> {
    Page<Store> findByNameContainingAndFoodCategory(String name, String foodCategory, Pageable pageable);

}
