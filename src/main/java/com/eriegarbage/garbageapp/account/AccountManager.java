package com.eriegarbage.garbageapp.account;

import java.util.ArrayList;
import java.util.List;

import com.eriegarbage.garbageapp.account.dto.AccountDto;
import com.eriegarbage.garbageapp.account.dto.AccountEditDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Account getAccount(String username) {
        return accountDao.findByUserName(username);
    }

    public void accountEditInfo(AccountEditDto dto, Account a) {
        a.setFirstName(dto.getFirstName());
        a.setLastName(dto.getLastName());
        a.setAddress(dto.getAddress());
        accountDao.save(a);
    }

    public void cancelAccount(Account account) {
        accountDao.delete(account);
    }

    public void requestSuspend(Account account) {
        account.setRequestSuspend(true);
        accountDao.save(account);
    }

    public ArrayList<Account> getSuspendableAccounts() {
        return accountDao.findByRequestSuspendTrue();
    }

    public void updateAnAccountAsSuspended(Account account) {
        account.setSuspensionApproved(true);
        accountDao.save(account);
    }

    private Account stepsForRegisterAccount(AccountDto dto) {
        Account account = new Account();
        account.setUserName(dto.getUsername());
        account.setFirstName(dto.getFirstName());
        account.setLastName(dto.getLastName());
        account.setAddress(dto.getAddress());
        account.setSuspended(false);
        account.setRequestSuspend(false);
        account.setSuspensionApproved(false);
        account.setAdmin(false);
        account.setPassword(passwordEncoder.encode(dto.getPassword()));
        account.setPickupTime("Pickup time not set yet");
        account.setEmail(dto.getEmail());
        return account;
    }

    public void registerNewAccount(AccountDto dto) {
        Account account = stepsForRegisterAccount(dto);
        accountDao.save(account);
    }

    public void registerNewAdmin(AccountDto dto) {
        Account account = stepsForRegisterAccount(dto);
        account.setAdmin(true);
        accountDao.save(account);
    }

    public List<Account> getOverdueAccounts() {
        List<Account> accounts = accountDao.findAll();
        List<Account> overdueAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.daysOverdue() >= 60) {
                overdueAccounts.add(account);
            }
        }
        return overdueAccounts;
    }

    public void suspend(int accountId) throws Exception {
        Account account = accountDao.findById(accountId).orElse(null);
        if(account == null) {
            throw new Exception(); //TODO: make custom exception
        }
        account.setSuspended(true);
        accountDao.save(account);
    }
}
