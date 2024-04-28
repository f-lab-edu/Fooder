package com.ryumina.fooder.domain.store.infra;

import com.ryumina.fooder.domain.store.model.Store;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudStoreRepository extends CrudRepository<Store, Long> {

    @Query("SELECT * " +
        "FROM STORE " +
        "WHERE (:foodCategory IS NULL OR :foodCategory = '' OR food_category = :foodCategory) " +
        "ORDER BY store_id ASC " +
        "LIMIT :size OFFSET :page")
    List<Store> findAllBy(String foodCategory, int size, int page);

}
