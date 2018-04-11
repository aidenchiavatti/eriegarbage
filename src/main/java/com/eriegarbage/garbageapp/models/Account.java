package com.eriegarbage.garbageapp.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private int accountID;
    private String firstName;
    private String lastName;
    private String userName;
    private List<Bill> bills;
    private String pickupTime;
    private boolean isAdmin;
    private boolean isSuspendable;
}
