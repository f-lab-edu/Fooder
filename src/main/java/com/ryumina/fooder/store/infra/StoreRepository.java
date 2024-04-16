package com.ryumina.fooder.store.infra;

import com.ryumina.fooder.store.domain.Store;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StoreRepository extends PagingAndSortingRepository<Store, Long> {
}
