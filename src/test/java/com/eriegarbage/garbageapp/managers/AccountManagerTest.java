package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.AccountDaoImpl;
import com.eriegarbage.garbageapp.models.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountManagerTest {

    private AccountManager accountManager = new AccountManager(new AccountDaoImpl());

    @Test
    public void getPickupTime() {
        assertEquals("Monday, 12AM", accountManager.getAccount("username").getPickupTime());
    }

    @Test
    public void createAndGetSameAccount() {
        Account account = new Account();
        account.setUserName("aiden");
        account.setAccountID(1);
        accountManager.createAccount(account);
        assertEquals(account, accountManager.getAccount("aiden"));
    }
}