package com.ryumina.fooder.domain.store.repository;

import com.ryumina.fooder.domain.store.infra.CrudMenuRepository;
import com.ryumina.fooder.domain.store.model.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepository {
    private final CrudMenuRepository crudMenuRepository;

    @Override
    public List<Menu> findByStoreId(Long storeId) {
        return crudMenuRepository.findByStoreId(storeId);
    }
}
