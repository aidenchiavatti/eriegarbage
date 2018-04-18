package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.BillDao;
import com.eriegarbage.garbageapp.models.Account;
import com.eriegarbage.garbageapp.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karle on 4/17/2018.
 */
@Service
public class BillingManager {
    @Autowired
    AccountManager accountManager;

    @Autowired
    private BillDao billDao;

    public BillingManager(BillDao billDao){ this.billDao = billDao; }

    public List<Bill> getBills(String username){
        Account account = accountManager.getAccount(username);
        return account.getBills();
    }
}