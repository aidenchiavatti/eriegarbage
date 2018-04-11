package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    private List<Account> accounts = new ArrayList<>();

    public AccountDaoImpl() {
        Account account = new Account();
        account.setUserName("username");
        account.setPickupTime("Monday, 12AM");
        accounts.add(account);
    }

    @Override
    public void createAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public Account getAccount(String username) {
        return accounts.stream().filter(a -> a.getUserName().equals(username)).findFirst().orElse(null);
    }
}
