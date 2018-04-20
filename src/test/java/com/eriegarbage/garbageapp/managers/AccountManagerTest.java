package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.models.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static com.eriegarbage.garbageapp.TestConstants.DEFAULT_ACCOUNT;
import static com.eriegarbage.garbageapp.TestConstants.DEFAULT_ACCOUNT_DTO;
import static com.eriegarbage.garbageapp.TestConstants.DEFAULT_USERNAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class AccountManagerTest {

    @Mock
    private AccountDao accountDao;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private AccountManager accountManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(accountDao.getAccountByUserName(DEFAULT_USERNAME)).thenReturn(DEFAULT_ACCOUNT);
    }
    @Test
    public void testGetAccount(){
        assertEquals(DEFAULT_ACCOUNT.getUserName(),
                accountManager.getAccount(DEFAULT_USERNAME).getUserName());
    }
}
