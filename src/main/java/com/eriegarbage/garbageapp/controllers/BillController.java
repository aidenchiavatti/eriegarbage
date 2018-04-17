package com.eriegarbage.garbageapp.controllers;

import com.eriegarbage.garbageapp.managers.BillingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
       // mv.addObject("accountInfo", "info");
        return mv;
    }
}
