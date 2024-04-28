package com.ryumina.fooder.domain.store.controller;

import com.ryumina.fooder.domain.store.controller.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.store.controller.dto.response.SearchStoresResponseDto;
import com.ryumina.fooder.domain.store.model.MenuBoard;
import com.ryumina.fooder.domain.store.model.Store;
import com.ryumina.fooder.domain.store.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{storeId}")
    public MenuBoard getMenuBoard(final @PathVariable Long storeId) {
        MenuBoard menuBoard = storeService.getMenuBoard(storeId);

        return menuBoard;
    }
}
