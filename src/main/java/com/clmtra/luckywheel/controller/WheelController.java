package com.clmtra.luckywheel.controller;

import com.clmtra.luckywheel.service.WheelService;
import com.clmtra.luckywheel.transfer.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wheel")
@RequiredArgsConstructor
public class WheelController {

    private final WheelService wheelService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addTemporaryData(@RequestBody OrderDTO orderDTO) {
        String formattedAmount = orderDTO.getAmount().replace(" ", "");
        orderDTO.setAmount(formattedAmount);
        System.out.println(orderDTO.toString());
        wheelService.addWheelToStorage(orderDTO);
    }

    @GetMapping("/{id}")
    public String getWheelOrder(@PathVariable String id) {

        return wheelService.getCurrentAmountForWheel(id);
    }

    @GetMapping
    public String greeting(){
        return "Hey!";
    }
}
