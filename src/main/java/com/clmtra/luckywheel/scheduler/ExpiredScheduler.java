package com.clmtra.luckywheel.scheduler;

import com.clmtra.luckywheel.service.WheelService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@RequiredArgsConstructor
public class ExpiredScheduler {

    private final WheelService wheelService;

    @Scheduled(fixedRate = 18000000)
    public void startClearExpired() {
//        wheelService.clearExpiredWheels();
    }
}
