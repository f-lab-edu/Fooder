package com.ryumina.fooder.domain.store.repository;

import com.ryumina.fooder.domain.store.infra.CrudMenuRepository;
import com.ryumina.fooder.domain.store.model.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepository {
    private final CrudMenuRepository crudMenuRepository;

    @Override
    public List<Menu> findByStoreId(Long storeId) {
        return crudMenuRepository.findByStoreId(storeId);
    }

    @Override
    public List<Menu> findAllById(List<Long> menuIdList) {
        Iterable<Menu> menus = crudMenuRepository.findAllById(menuIdList);

        List<Menu> menuList = new ArrayList<>();

        for (Menu menu : menus) {
            menuList.add(menu);
        }

        return menuList;
    }
}
