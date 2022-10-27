package com.clmtra.luckywheel.service.impl;

import com.clmtra.luckywheel.service.WheelService;
import com.clmtra.luckywheel.transfer.OrderDTO;
import org.springframework.stereotype.Service;

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
    public OrderDTO getCurrentAmountForWheel(String id) {
        var orderCustomer = wheelStorage.remove(id);

        if (orderCustomer == null) {
            return null;
        }

        var orderDTO = new OrderDTO();
        orderDTO.setSessionId(id);
        orderDTO.setAmount(orderCustomer);

        return orderDTO;
    }
}
