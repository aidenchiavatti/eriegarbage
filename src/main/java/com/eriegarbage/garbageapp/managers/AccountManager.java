package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.dto.AccountDto;
import com.eriegarbage.garbageapp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountManager {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountManager(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void createAccount(Account account) {
        accountDao.save(account);
    }

    public Account getAccount(String username) {
        return accountDao.getAccountByUserName(username);
    }

    public void registerNewAccount(AccountDto dto) {
        Account account = new Account();
        account.setUserName(dto.getUsername());
        account.setFirstName(dto.getFirstName());
        account.setLastName(dto.getLastName());
        account.setAdmin(false);
        account.setPassword(passwordEncoder.encode(dto.getPassword()));
        account.setPickupTime("Pickup time not set yet");
        accountDao.save(account);
    }
}
