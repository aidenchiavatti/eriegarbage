//package com.eriegarbage.garbageapp.managers;
//
//import com.eriegarbage.garbageapp.dao.AccountDao;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static com.eriegarbage.garbageapp.TestConstants.DEFAULT_ACCOUNT;
//import static com.eriegarbage.garbageapp.TestConstants.DEFAULT_USERNAME;
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//public class AccountManagerTest {
//
//    @Mock
//    private AccountDao accountDao;
//
//    @Mock
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private AccountManager accountManager;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        Mockito.when(accountDao.getAccountByUserName(DEFAULT_USERNAME)).thenReturn(DEFAULT_ACCOUNT);
//    }
//    @Test
//    public void testGetAccount(){
//        assertEquals(DEFAULT_ACCOUNT.getUserName(),
//                accountManager.getAccount(DEFAULT_USERNAME).getUserName());
//    }
//}
