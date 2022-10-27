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

    @PostConstruct
    public void initStorage() {
        wheelStorage.put("0", "Hello");
    }

    @Override
    public void addWheelToStorage(OrderDTO orderDTO) {
        wheelStorage.put(orderDTO.getSessionId(), orderDTO.getAmount());
    }

    @Override
    public OrderDTO getCurrentAmountForWheel(String id) {
        String orderCustomer = wheelStorage.remove(id);

        if (orderCustomer == null) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setSessionId(id);
        orderDTO.setAmount(orderCustomer);

        return orderDTO;
    }
}
