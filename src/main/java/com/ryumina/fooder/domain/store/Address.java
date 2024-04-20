package com.ryumina.fooder.domain.store;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "STORE_ADDRESS")
@Getter
public class Address {

    @Id
    @Column("STORE_ADDRESS_ID")
    private Long id;

    @Column("STORE_ID")
    private Long storeId;

    @Column("ZIP_CODE")
    private String zipCode;

    @Column("ADDRESS")
    private String address;

    @Column("DETAIL_ADDRESS")
    private String detailAddress;

}
