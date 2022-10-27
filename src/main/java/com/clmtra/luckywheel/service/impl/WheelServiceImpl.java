package com.clmtra.luckywheel.service.impl;

import com.clmtra.luckywheel.service.WheelService;
import com.clmtra.luckywheel.transfer.OrderDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WheelServiceImpl implements WheelService {

    private final static Map<String, String> wheelStorage = new ConcurrentHashMap<>();

    @Override
    public void addWheelToStorage(OrderDTO orderDTO) {
        wheelStorage.put(orderDTO.getSessionId(), orderDTO.getAmount());
    }

    @Override
    public String getCurrentAmountForWheel(String id) {
        String amount = wheelStorage.remove(id);
        if (amount == null) {
            amount = "0";
        }

        System.out.println("Result: " + amount);

        return amount;
    }
}
