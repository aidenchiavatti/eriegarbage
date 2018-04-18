package com.eriegarbage.garbageapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private String dueDate;
    private double total;
    @OneToMany
    private List<Dispute> disputes;
}
