package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.dto.AccountDto;
import com.eriegarbage.garbageapp.dto.OverdueAccountDto;
import com.eriegarbage.garbageapp.models.Account;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AccountManagerTest {
    @Mock
    private AccountDao accountDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    AccountManager accountManager;

    private AccountDto accountDto;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Account account = new Account();
        account.setUserName("user");

        accountDto = new AccountDto();
        accountDto.setEmail("email");
        accountDto.setPassword("password");
        accountDto.setFirstName("test");
        accountDto.setLastName("user");
        accountDto.setUsername("user");

        List<Account> accounts = new ArrayList<>();
        accounts.add(account);

        when(accountDao.findByUserName("user")).thenReturn(account);
        when(passwordEncoder.encode("password")).thenReturn("encoded");
        when(accountDao.findAll()).thenReturn(accounts);
    }

    @Test
    public void getAccount() {
        assertEquals(accountManager.getAccount("user").getUserName(), "user");
    }

    @Test
    public void accountEditInfo() {
    }

    @Test
    public void cancelAccount() {
    }

    @Test
    public void requestSuspend() {
    }

    @Test
    public void getSuspendableAccounts() {
    }

    @Test
    public void updateAnAccountAsSuspended() {
    }

    @Test
    public void registerNewAccount() {
    }

    @Test
    public void registerNewAdmin() {
    }

    @Test
    public void getOverdueAccounts() {
        List<OverdueAccountDto> accountDtos = accountManager.getOverdueAccounts();
    }
}