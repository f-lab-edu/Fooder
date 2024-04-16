package com.ryumina.fooder.store.controller;

import com.ryumina.fooder.store.domain.Store;
import com.ryumina.fooder.store.infra.Paging;
import com.ryumina.fooder.store.infra.Response;
import com.ryumina.fooder.store.infra.Result;
import com.ryumina.fooder.store.infra.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    public Response<Paging<List<Store>>> searchStores(@RequestParam int page, @RequestParam int size) {
        Page<Store> storeList = storeService.searchStores(page, size);

        return Response.<Paging<List<Store>>>builder(Result.SUCCESS.getCode(),
                                                     Result.SUCCESS.getMessage())
                       .data(Paging.builder(storeList.getTotalElements(),
                                            page,
                                            size,
                                            storeList.getContent())
                                   .build())

                       .build();
    }

}
