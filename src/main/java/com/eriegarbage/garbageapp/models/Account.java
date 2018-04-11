package com.eriegarbage.garbageapp.models;

import java.util.List;

public class Account {
    private int accountID;
    private String firstName;
    private String lastName;
    private String userName;
    private List<Bill> bills;
    private boolean isAdmin;
    private boolean isSuspendable;
}
