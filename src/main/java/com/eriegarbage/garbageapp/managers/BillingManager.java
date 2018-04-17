package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.BillDao;
import com.eriegarbage.garbageapp.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by karle on 4/17/2018.
 */
@Service
public class BillingManager {
    @Autowired
    private BillDao billDao;

    public BillingManager(BillDao billDao){ this.billDao = billDao; }

    public Bill getBill(){
        return new Bill();
       // return billDao.getBill()
    }
}
