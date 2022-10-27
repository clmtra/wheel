package com.clmtra.luckywheel.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDTO implements Serializable {

    @JsonProperty("session_id")
    private String sessionId;

    @JsonProperty("amount")
    private String amount;
}
