package com.eriegarbage.garbageapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PaymentDto implements Serializable {
    private String cardType;
    private String cardNumber;
    private double paymentAmount;
}
