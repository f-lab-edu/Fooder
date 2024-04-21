package com.ryumina.fooder.domain.time;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class OpeningTime {
    private LocalTime startTime;
    private LocalTime finishTime;

    public static boolean isOpeningTime(LocalTime startTime, LocalTime finishTime) {
        LocalTime now = LocalTime.now();
        return now.isAfter(startTime) && now.isBefore(finishTime);
    };

}
