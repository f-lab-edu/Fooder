package com.ryumina.fooder.domain.time;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalTime;

@Table(name = "STORE_TIME")
@Getter
public class Time {

    @Id
    @Column("STORE_ID")
    private Long storeId;

    @Column("START_TIME")
    private LocalTime startTime;

    @Column("FINISH_TIME")
    private LocalTime finishTime;

    public boolean isOpeningTime(LocalTime startTime, LocalTime finishTime) {
        LocalTime now = LocalTime.now();
        return now.isAfter(startTime) && now.isBefore(finishTime);
    };

}
