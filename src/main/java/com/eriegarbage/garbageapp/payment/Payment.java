package com.eriegarbage.garbageapp.payment;

import com.eriegarbage.garbageapp.bill.Bill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long paymentID;
    private Date date;
    private double paymentTotal;
    private String creditCardNumber;
    private Date creditCardExpiry;
    private String cvc;

    @JsonIgnore
    @OneToOne
    private Bill bill;

    public String generateReceipt(){
        //generate receipt and send to billing manager
        return "Payment ID: " + paymentID + "\nPayment Date: " + date.toString()
                + "\nPayment Amount: " + paymentTotal;

    }
}
