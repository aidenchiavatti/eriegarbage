package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.dto.AccountDto;
import com.eriegarbage.garbageapp.dto.AccountEditDto;
import com.eriegarbage.garbageapp.dto.OverdueAccountDto;
import com.eriegarbage.garbageapp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return accountDao.getAccountByUserName(username);
    }

    public void accountEditInfo(AccountEditDto dto, Account a) {
        accountDao.updateAccountInfo(dto.getFirstName(), dto.getLastName(), dto.getAddress(), a.getAccountID());
    }

    public void cancelAccount(Account a) {
        accountDao.deleteAccount(a.getAccountID());
    }

    public void requestSuspend(Account a) {
        accountDao.updateAccountSuspendRequest(a.getAccountID());
    }

    public ArrayList<Account> getSuspendableAccounts() {
        return accountDao.getAccountsThatRequestSuspension();
    }

    public void updateAnAccountAsSuspended(String username) {
        accountDao.updateAccountSuspendedApproved(username);
    }

    private Account stepsForRegisterAccount(AccountDto dto)
    {
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

    public List<OverdueAccountDto> getOverdueAccounts() {
        List<Account> accounts = accountDao.findAll();
        List<OverdueAccountDto> overdueAccounts = new ArrayList<>();
        for(Account account : accounts) {
            if(account.daysOverdue() >= 60) {
                OverdueAccountDto overdueAccount = new OverdueAccountDto();
                overdueAccount.setAccountId(account.getAccountID());
                overdueAccount.setDaysOverdue(account.daysOverdue());
                overdueAccount.setUsername(account.getUserName());
                overdueAccounts.add(overdueAccount);
            }
        }
        Collections.sort(overdueAccounts);
        Collections.reverse(overdueAccounts);
        return overdueAccounts;
    }
}
