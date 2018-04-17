package com.eriegarbage.garbageapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int paymentID;
    private String date;
    private double paymentTotal;

    public String generateReceipt(){
        //generate receipt and send to billing manager
        return "";

    }
}
