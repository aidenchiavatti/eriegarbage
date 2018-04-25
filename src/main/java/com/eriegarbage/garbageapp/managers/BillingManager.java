package com.eriegarbage.garbageapp.managers;

import com.eriegarbage.garbageapp.dao.BillDao;
import com.eriegarbage.garbageapp.dao.DisputeDao;
import com.eriegarbage.garbageapp.dao.PaymentDao;
import com.eriegarbage.garbageapp.dto.PaymentDto;
import com.eriegarbage.garbageapp.exceptions.InvalidPaymentException;
import com.eriegarbage.garbageapp.models.Bill;
import com.eriegarbage.garbageapp.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by karle on 4/17/2018.
 */
@Service
public class BillingManager {
    @Autowired
    private BillDao billDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private DisputeDao disputeDao;

    public BillingManager(BillDao billDao){ this.billDao = billDao; }

    public List<Bill> getBills(String username){
        return billDao.findUnpaidBillsByUsername(username);
    }

    public void payBill(int billID, PaymentDto paymentDto) throws InvalidPaymentException {
        Bill bill = billDao.findByBillId(billID);
        Payment payment = new Payment();
        payment.setDate(Calendar.getInstance().getTime());
        payment.setPaymentTotal(paymentDto.getPaymentAmount());
        payment.setBill(bill);

        //verify payment is not more than the billTotal
        if(payment.getPaymentTotal() != bill.getTotal()) {
            throw new InvalidPaymentException("Payment must equal bill");
        }

        //verify and make payment


        bill.pay(payment);
        billDao.save(bill);
    }

    public List<Payment> getPaymentsForUsername(String username) {
        return paymentDao.findPaymentsForUsername(username);
    }

    public List<Payment> getPayments() {
        return paymentDao.findAll();
    }

    public void sendReceipt(Long id) throws MessagingException {
        Payment payment = paymentDao.findById(id).orElse(null);
        if(payment != null) {
            emailService.sendReceipt(payment.getBill().getAccount().getEmail(), payment);
        }
    }

    public void respondToDispute(int id, String response){
        disputeDao.respondToDispute(id, response);
    }
}
