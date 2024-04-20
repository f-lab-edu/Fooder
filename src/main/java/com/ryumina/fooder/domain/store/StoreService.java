package com.ryumina.fooder.domain.store;

import com.ryumina.fooder.domain.store.dto.request.StoreSearchRequestDto;
import com.ryumina.fooder.domain.time.Time;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public List<Store> searchStores(StoreSearchRequestDto requestDto) {
        List<Store> stores = storeRepository.searchStores(requestDto);

        Time time = new Time();
        for (Store store : stores) {
            boolean isOpeningTime = time.isOpeningTime(store.getTime().getStartTime(), store.getTime().getFinishTime());

            if (isOpeningTime) {
                store.open();
            }
        }

        return stores;
    }
}
