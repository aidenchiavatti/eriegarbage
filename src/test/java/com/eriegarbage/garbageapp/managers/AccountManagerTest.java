package com.eriegarbage.garbageapp.managers;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountManagerTest {

    private AccountManager accountManager = new AccountManager();

    @Test
    public void getPickupTime() {
        assertEquals("Monday, 12AM", accountManager.getPickupTime("stuff"));
    }
}