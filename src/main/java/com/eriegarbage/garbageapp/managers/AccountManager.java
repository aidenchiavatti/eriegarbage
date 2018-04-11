package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.dao.AccountDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountManager {
    private AccountDao accountDao = new AccountDaoImpl();

    public String getPickupTime(String username) {
        return accountDao.getPickupTime(username);
    }
}
