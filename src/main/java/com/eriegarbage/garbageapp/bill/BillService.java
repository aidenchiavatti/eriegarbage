package com.eriegarbage.garbageapp.bill;

import com.eriegarbage.garbageapp.payment.InvalidPaymentException;
import com.eriegarbage.garbageapp.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by karle on 4/17/2018.
 */
@Service
public class BillService {
    @Autowired
    private BillDao billDao;

    public List<Bill> getBillsForUser(String username) {
        return billDao.findByAccountUserNameAndTotalGreaterThan(username, 0);
    }

    public void payBill(long billId, Payment payment) throws InvalidPaymentException {
        payment.setDate(Calendar.getInstance().getTime());
        Bill bill = billDao.findById(billId).get(); //TODO: check for null
        payment.setBill(bill);

        //verify payment is not more than the billTotal
        if (payment.getPaymentTotal() != bill.getTotal()) {
            throw new InvalidPaymentException("Payment must equal bill");
        }

        //verify and make payment
        bill.pay(payment);
        billDao.save(bill);
    }

    public List<Bill> getBills() {
        return billDao.findAll();
    }
}
