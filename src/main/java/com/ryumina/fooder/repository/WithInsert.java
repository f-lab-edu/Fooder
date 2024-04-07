package com.ryumina.fooder.repository;

import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.transaction.annotation.Transactional;

public interface WithInsert<T> {
    JdbcAggregateOperations getJdbcAggregateOperations();

    @Transactional
    default T insert(T instance) {
        return getJdbcAggregateOperations().insert(instance);
    }
}
