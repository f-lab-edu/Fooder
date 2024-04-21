package com.ryumina.fooder.domain.store;

import com.ryumina.fooder.domain.store.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.dto.response.SearchStoresResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    public List<SearchStoresResponseDto> searchStores(final @RequestBody @Valid StoreSearchRequestDto requestDto) {
        List<Store> stores = storeService.searchStores(requestDto);

        return stores.stream()
                     .map(SearchStoresResponseDto::from)
                     .collect(Collectors.toList());
    }

}
