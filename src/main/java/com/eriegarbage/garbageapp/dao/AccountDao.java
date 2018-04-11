package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Account;

public interface AccountDao {

    void createAccount(Account account);

    Account getAccount(String username);
}
