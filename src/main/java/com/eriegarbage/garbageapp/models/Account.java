package com.eriegarbage.garbageapp.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int accountID;

    private String firstName;
    private String lastName;
    private String userName;
    private String address;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "account")
    private List<Bill> bills;

    private String pickupTime;
    private boolean isAdmin;
    private boolean isSuspended;

    public void addBill(Bill bill) {
        this.bills.add(bill);
    }
}
