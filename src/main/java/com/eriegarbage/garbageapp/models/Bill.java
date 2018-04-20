package com.eriegarbage.garbageapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int billID;
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
    private Date dueDate;
    private double total;
    @OneToMany
    private List<Dispute> disputes;

    @ManyToOne(cascade=CascadeType.ALL)
    private Account account;

    public void pay(Payment payment) {
        this.total = 0;
        this.payment = payment;
    }
}
