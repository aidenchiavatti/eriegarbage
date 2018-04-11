package com.eriegarbage.garbageapp.models;

import java.util.ArrayList;

public class Bill {
    private int billID;
    private Payment payment;
    private String dueDate;
    private double total;
    private ArrayList<Dispute> disputes;
}
