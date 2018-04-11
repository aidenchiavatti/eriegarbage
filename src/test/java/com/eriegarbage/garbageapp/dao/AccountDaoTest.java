package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.AccountDaoTestImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountDaoTest {

    private AccountDaoTestImpl accountDao = new AccountDaoTestImpl();

    @Test
    public void getPickupTime() {
        assertEquals("Monday, 12AM", accountDao.getPickupTime("username"));
    }
}