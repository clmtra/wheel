package com.clmtra.luckywheel.service;

import com.clmtra.luckywheel.transfer.OrderDTO;

public interface WheelService {

    void addWheelToStorage(OrderDTO orderDTO);

    OrderDTO getCurrentAmountForWheel(String id);
}
