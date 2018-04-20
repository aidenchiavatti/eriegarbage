package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.AccountDao;
import com.eriegarbage.garbageapp.dto.PaymentDto;
import com.eriegarbage.garbageapp.exceptions.InvalidPaymentException;
import com.eriegarbage.garbageapp.models.Account;
import com.eriegarbage.garbageapp.models.Bill;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static com.eriegarbage.garbageapp.TestConstants.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingManagerTest {

    @Autowired
    private BillingManager billingManager;

    @Test
    public void getBills() {
        List<Bill> bills = billingManager.getBills(DEFAULT_USERNAME);
        assertEquals(2, bills.size());
        assertEquals(BILL_1.getTotal(), bills.get(0).getTotal(), 0.01);
        assertEquals(BILL_1.getDueDate(), bills.get(0).getDueDate());
        assertEquals(BILL_2.getTotal(), bills.get(1).getTotal(), 0.01);
        assertEquals(BILL_2.getDueDate(), bills.get(1).getDueDate());
    }

    @Test
    public void payBill() throws InvalidPaymentException {
        List<Bill> bills = billingManager.getBills(DEFAULT_USERNAME);
        int billID = bills.get(0).getBillID();
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setCardNumber("1234");
        paymentDto.setCardType("Discover");
        paymentDto.setPaymentAmount(20);

        billingManager.payBill(billID, paymentDto);
        bills = billingManager.getBills(DEFAULT_USERNAME);
        assertEquals(0, bills.get(0).getTotal(), 0.01);
    }
}