package com.ryumina.fooder.domain.store.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class OpeningTime {
    private LocalTime startTime;
    private LocalTime finishTime;

    public OpeningTime() {
    }

    @Builder
    public OpeningTime(LocalTime startTime, LocalTime finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public boolean isOpeningTime(LocalTime startTime, LocalTime finishTime) {
        LocalTime now = LocalTime.now();
        return now.isAfter(startTime) && now.isBefore(finishTime);
    };

}
