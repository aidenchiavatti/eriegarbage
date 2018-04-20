package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.BillDao;
import com.eriegarbage.garbageapp.dto.PaymentDto;
import com.eriegarbage.garbageapp.exceptions.InvalidPaymentException;
import com.eriegarbage.garbageapp.models.Account;
import com.eriegarbage.garbageapp.models.Bill;
import com.eriegarbage.garbageapp.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by karle on 4/17/2018.
 */
@Service
public class BillingManager {
    @Autowired
    private AccountManager accountManager;

    @Autowired
    private BillDao billDao;

    public BillingManager(BillDao billDao){ this.billDao = billDao; }

    public List<Bill> getBills(String username){
        Account account = accountManager.getAccount(username);
        return account.getBills();
    }

    public void payBill(int billID, PaymentDto paymentDto) throws InvalidPaymentException {
        Bill bill = billDao.findByBillID(billID);
        Payment payment = new Payment();
        payment.setDate(Calendar.getInstance().getTime());
        payment.setPaymentTotal(paymentDto.getPaymentAmount());

        //verify payment is not more than the billTotal
        if(payment.getPaymentTotal() != bill.getTotal()) {
            throw new InvalidPaymentException("Payment must equal bill");
        }

        //verify and make payment


        bill.pay(payment);
        billDao.save(bill);
    }
}
