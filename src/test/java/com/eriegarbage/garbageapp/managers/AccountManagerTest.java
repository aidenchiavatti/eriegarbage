package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.models.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountManagerTest {

    @Autowired
    AccountManager accountManager;

    @Test
    public void testCreateAndGetAccount() throws Exception {
        Account account = new Account();
        account.setUserName("testAccount");
        accountManager.createAccount(account);
        assertEquals(account.getUserName(), accountManager.getAccount("testAccount").getUserName());
    }
}
