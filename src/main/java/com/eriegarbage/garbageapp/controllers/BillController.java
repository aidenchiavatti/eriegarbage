package com.eriegarbage.garbageapp.controllers;

import com.eriegarbage.garbageapp.dto.PaymentDto;
import com.eriegarbage.garbageapp.managers.BillingManager;
import com.eriegarbage.garbageapp.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by karle on 4/17/2018.
 */
@Controller
public class BillController {

    @Autowired
    BillingManager billingManager;

    @RequestMapping(value = "/billPage")
    public ModelAndView getBillPage() {
        ModelAndView mv = new ModelAndView("BillPage");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Bill> bills = billingManager.getBills(username);
        mv.addObject("bills", bills);
        return mv;
    }

    @RequestMapping(value = "/payBill")
    @ResponseStatus(value = HttpStatus.OK)
    public void payBill(@RequestParam int id, @RequestBody PaymentDto paymentDto) {
        billingManager.payBill(id, paymentDto);
    }

    @RequestMapping(value = "/viewPayments")
    public ModelAndView getPaymentsPage() {
        ModelAndView mv = new ModelAndView("SendReceiptPage");
        mv.addObject("payments", billingManager.getPayments());
        return mv;
    }

    @RequestMapping(value = "/sendReceipt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void sendReceipt(@RequestParam Long id) {
        try {
            billingManager.sendReceipt(id);
        } catch (Exception e) {
            System.out.println("Issues sending email");
            e.printStackTrace();
        }
    }
}
