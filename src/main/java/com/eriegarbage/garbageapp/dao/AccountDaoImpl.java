package com.eriegarbage.garbageapp.dao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public String getPickupTime(String username) {
        return "Monday, 12AM";
    }
}
