package com.eriegarbage.garbageapp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService payments;

    @GetMapping("/admin/payments") //TODO: add security mapping
    @ResponseBody
    public List<Payment> payments() {
        return payments.getAll();
    }

    @PostMapping("/admin/payments/{paymentId}/email")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendReceipt(@PathVariable("paymentId") Long paymentId) {
        try {
            payments.sendReceipt(paymentId);
        } catch (Exception e) {
            System.out.println("Issues sending email");
            e.printStackTrace(); //TODO: exception return?
        }
    }
}
