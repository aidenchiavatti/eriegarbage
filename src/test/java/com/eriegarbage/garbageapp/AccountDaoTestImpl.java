package com.eriegarbage.garbageapp;

import com.eriegarbage.garbageapp.dao.AccountDao;

public class AccountDaoTestImpl implements AccountDao {

    @Override
    public String getPickupTime(String username) {
        return "Monday, 12AM";
    }
}
