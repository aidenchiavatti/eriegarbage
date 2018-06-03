package com.eriegarbage.garbageapp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private EmailService emailService;

    public List<Payment> getAll() {
        return paymentDao.findAll();
    }

    public void sendReceipt(Long paymentId) throws MessagingException {
        Payment payment = paymentDao.findById(paymentId).orElse(null);
        if (payment != null) {
            emailService.sendReceipt(payment.getBill().getAccount().getEmail(), payment);
        }
    }
}
