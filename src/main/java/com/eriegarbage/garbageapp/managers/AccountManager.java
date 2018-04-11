package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.dao.AccountDaoImpl;
import com.eriegarbage.garbageapp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountManager {
    @Autowired
    private AccountDao accountDao;

    public AccountManager(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void createAccount(Account account) {
        accountDao.createAccount(account);
    }

    public Account getAccount(String username) {
        return accountDao.getAccount(username);
    }
}
