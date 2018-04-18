package com.eriegarbage.garbageapp.controllers;

import com.eriegarbage.garbageapp.managers.BillingManager;
import com.eriegarbage.garbageapp.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
