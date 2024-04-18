package com.ryumina.fooder.domain.store;

import com.ryumina.fooder.domain.store.dto.response.SearchStoresResponseDto;
import com.ryumina.fooder.infra.Paging;
import com.ryumina.fooder.infra.Response;
import com.ryumina.fooder.infra.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    public Response<Paging<List<SearchStoresResponseDto>>> searchStores(@RequestParam int page, @RequestParam int size) {
        Page<Store> storeList = storeService.searchStores(page, size);

        return Response.<Paging<List<SearchStoresResponseDto>>>builder(Result.SUCCESS.getCode(),
                                                                       Result.SUCCESS.getMessage())
                       .data(Paging.builder(storeList.getTotalElements(),
                                            page,
                                            size,
                                            storeList.getContent()
                                                     .stream()
                                                     .map(SearchStoresResponseDto::from)
                                                     .collect(Collectors.toList()))
                                   .build())

                       .build();
    }

}
