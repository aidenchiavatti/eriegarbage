package com.eriegarbage.garbageapp.dao;

import com.eriegarbage.garbageapp.models.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountDaoTest {

    @Autowired
    AccountDao accountDao;

    @Test
    public void testGetAccount() throws Exception {
        Account account = accountDao.getAccountByUserName("username");
        assertEquals("username", account.getUserName());
        assertEquals("Monday, 11 PM", account.getPickupTime());
    }
}
