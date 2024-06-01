package com.ryumina.fooder.domain.store.infra;

import com.ryumina.fooder.domain.store.model.entity.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudMenuRepository extends CrudRepository<Menu, Long> {
    List<Menu> findByStoreId(Long storeId);

}
