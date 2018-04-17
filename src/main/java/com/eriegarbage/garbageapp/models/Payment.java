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
<<<<<<< HEAD
=======
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int paymentID;
>>>>>>> ca86f89229eae0d45a6b2a1d4a5d3ab2e519682f
    private String date;
    private double paymentTotal;

    public String generateReceipt(){
<<<<<<< HEAD
        //generate receipt and send to billing manager

=======
        return "";
>>>>>>> ca86f89229eae0d45a6b2a1d4a5d3ab2e519682f
    }
}
